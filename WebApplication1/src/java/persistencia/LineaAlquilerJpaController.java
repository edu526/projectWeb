/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Miriam
 */
public class LineaAlquilerJpaController implements Serializable {

    public LineaAlquilerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public LineaAlquilerJpaController() {
        emf=Persistence.createEntityManagerFactory("AlquilerEmpPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LineaAlquiler lineaAlquiler) throws PreexistingEntityException, Exception {
        if (lineaAlquiler.getLineaAlquilerPK() == null) {
            lineaAlquiler.setLineaAlquilerPK(new LineaAlquilerPK());
        }
        lineaAlquiler.getLineaAlquilerPK().setCodrut(lineaAlquiler.getRuta().getCodrut());
        lineaAlquiler.getLineaAlquilerPK().setNumalq(lineaAlquiler.getAlquiler().getNumalq());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alquiler alquiler = lineaAlquiler.getAlquiler();
            if (alquiler != null) {
                alquiler = em.getReference(alquiler.getClass(), alquiler.getNumalq());
                lineaAlquiler.setAlquiler(alquiler);
            }
            Ruta ruta = lineaAlquiler.getRuta();
            if (ruta != null) {
                ruta = em.getReference(ruta.getClass(), ruta.getCodrut());
                lineaAlquiler.setRuta(ruta);
            }
            em.persist(lineaAlquiler);
            if (alquiler != null) {
                alquiler.getLineaAlquilerList().add(lineaAlquiler);
                alquiler = em.merge(alquiler);
            }
            if (ruta != null) {
                ruta.getLineaAlquilerList().add(lineaAlquiler);
                ruta = em.merge(ruta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLineaAlquiler(lineaAlquiler.getLineaAlquilerPK()) != null) {
                throw new PreexistingEntityException("LineaAlquiler " + lineaAlquiler + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LineaAlquiler lineaAlquiler) throws NonexistentEntityException, Exception {
        lineaAlquiler.getLineaAlquilerPK().setCodrut(lineaAlquiler.getRuta().getCodrut());
        lineaAlquiler.getLineaAlquilerPK().setNumalq(lineaAlquiler.getAlquiler().getNumalq());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LineaAlquiler persistentLineaAlquiler = em.find(LineaAlquiler.class, lineaAlquiler.getLineaAlquilerPK());
            Alquiler alquilerOld = persistentLineaAlquiler.getAlquiler();
            Alquiler alquilerNew = lineaAlquiler.getAlquiler();
            Ruta rutaOld = persistentLineaAlquiler.getRuta();
            Ruta rutaNew = lineaAlquiler.getRuta();
            if (alquilerNew != null) {
                alquilerNew = em.getReference(alquilerNew.getClass(), alquilerNew.getNumalq());
                lineaAlquiler.setAlquiler(alquilerNew);
            }
            if (rutaNew != null) {
                rutaNew = em.getReference(rutaNew.getClass(), rutaNew.getCodrut());
                lineaAlquiler.setRuta(rutaNew);
            }
            lineaAlquiler = em.merge(lineaAlquiler);
            if (alquilerOld != null && !alquilerOld.equals(alquilerNew)) {
                alquilerOld.getLineaAlquilerList().remove(lineaAlquiler);
                alquilerOld = em.merge(alquilerOld);
            }
            if (alquilerNew != null && !alquilerNew.equals(alquilerOld)) {
                alquilerNew.getLineaAlquilerList().add(lineaAlquiler);
                alquilerNew = em.merge(alquilerNew);
            }
            if (rutaOld != null && !rutaOld.equals(rutaNew)) {
                rutaOld.getLineaAlquilerList().remove(lineaAlquiler);
                rutaOld = em.merge(rutaOld);
            }
            if (rutaNew != null && !rutaNew.equals(rutaOld)) {
                rutaNew.getLineaAlquilerList().add(lineaAlquiler);
                rutaNew = em.merge(rutaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                LineaAlquilerPK id = lineaAlquiler.getLineaAlquilerPK();
                if (findLineaAlquiler(id) == null) {
                    throw new NonexistentEntityException("The lineaAlquiler with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(LineaAlquilerPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LineaAlquiler lineaAlquiler;
            try {
                lineaAlquiler = em.getReference(LineaAlquiler.class, id);
                lineaAlquiler.getLineaAlquilerPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lineaAlquiler with id " + id + " no longer exists.", enfe);
            }
            Alquiler alquiler = lineaAlquiler.getAlquiler();
            if (alquiler != null) {
                alquiler.getLineaAlquilerList().remove(lineaAlquiler);
                alquiler = em.merge(alquiler);
            }
            Ruta ruta = lineaAlquiler.getRuta();
            if (ruta != null) {
                ruta.getLineaAlquilerList().remove(lineaAlquiler);
                ruta = em.merge(ruta);
            }
            em.remove(lineaAlquiler);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LineaAlquiler> findLineaAlquilerEntities() {
        return findLineaAlquilerEntities(true, -1, -1);
    }

    public List<LineaAlquiler> findLineaAlquilerEntities(int maxResults, int firstResult) {
        return findLineaAlquilerEntities(false, maxResults, firstResult);
    }

    private List<LineaAlquiler> findLineaAlquilerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LineaAlquiler.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public LineaAlquiler findLineaAlquiler(LineaAlquilerPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LineaAlquiler.class, id);
        } finally {
            em.close();
        }
    }

    public int getLineaAlquilerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LineaAlquiler> rt = cq.from(LineaAlquiler.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

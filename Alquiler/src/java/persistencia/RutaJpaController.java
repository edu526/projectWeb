/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author edd
 */
public class RutaJpaController implements Serializable {

    public RutaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
public RutaJpaController() {
        
        this.emf = Persistence.createEntityManagerFactory("AlquilerPU");
    }
    public void create(Ruta ruta) throws PreexistingEntityException, Exception {
        if (ruta.getLineaAlquilerList() == null) {
            ruta.setLineaAlquilerList(new ArrayList<LineaAlquiler>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<LineaAlquiler> attachedLineaAlquilerList = new ArrayList<LineaAlquiler>();
            for (LineaAlquiler lineaAlquilerListLineaAlquilerToAttach : ruta.getLineaAlquilerList()) {
                lineaAlquilerListLineaAlquilerToAttach = em.getReference(lineaAlquilerListLineaAlquilerToAttach.getClass(), lineaAlquilerListLineaAlquilerToAttach.getLineaAlquilerPK());
                attachedLineaAlquilerList.add(lineaAlquilerListLineaAlquilerToAttach);
            }
            ruta.setLineaAlquilerList(attachedLineaAlquilerList);
            em.persist(ruta);
            for (LineaAlquiler lineaAlquilerListLineaAlquiler : ruta.getLineaAlquilerList()) {
                Ruta oldRutaOfLineaAlquilerListLineaAlquiler = lineaAlquilerListLineaAlquiler.getRuta();
                lineaAlquilerListLineaAlquiler.setRuta(ruta);
                lineaAlquilerListLineaAlquiler = em.merge(lineaAlquilerListLineaAlquiler);
                if (oldRutaOfLineaAlquilerListLineaAlquiler != null) {
                    oldRutaOfLineaAlquilerListLineaAlquiler.getLineaAlquilerList().remove(lineaAlquilerListLineaAlquiler);
                    oldRutaOfLineaAlquilerListLineaAlquiler = em.merge(oldRutaOfLineaAlquilerListLineaAlquiler);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRuta(ruta.getCodrut()) != null) {
                throw new PreexistingEntityException("Ruta " + ruta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ruta ruta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ruta persistentRuta = em.find(Ruta.class, ruta.getCodrut());
            List<LineaAlquiler> lineaAlquilerListOld = persistentRuta.getLineaAlquilerList();
            List<LineaAlquiler> lineaAlquilerListNew = ruta.getLineaAlquilerList();
            List<String> illegalOrphanMessages = null;
            for (LineaAlquiler lineaAlquilerListOldLineaAlquiler : lineaAlquilerListOld) {
                if (!lineaAlquilerListNew.contains(lineaAlquilerListOldLineaAlquiler)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LineaAlquiler " + lineaAlquilerListOldLineaAlquiler + " since its ruta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<LineaAlquiler> attachedLineaAlquilerListNew = new ArrayList<LineaAlquiler>();
            for (LineaAlquiler lineaAlquilerListNewLineaAlquilerToAttach : lineaAlquilerListNew) {
                lineaAlquilerListNewLineaAlquilerToAttach = em.getReference(lineaAlquilerListNewLineaAlquilerToAttach.getClass(), lineaAlquilerListNewLineaAlquilerToAttach.getLineaAlquilerPK());
                attachedLineaAlquilerListNew.add(lineaAlquilerListNewLineaAlquilerToAttach);
            }
            lineaAlquilerListNew = attachedLineaAlquilerListNew;
            ruta.setLineaAlquilerList(lineaAlquilerListNew);
            ruta = em.merge(ruta);
            for (LineaAlquiler lineaAlquilerListNewLineaAlquiler : lineaAlquilerListNew) {
                if (!lineaAlquilerListOld.contains(lineaAlquilerListNewLineaAlquiler)) {
                    Ruta oldRutaOfLineaAlquilerListNewLineaAlquiler = lineaAlquilerListNewLineaAlquiler.getRuta();
                    lineaAlquilerListNewLineaAlquiler.setRuta(ruta);
                    lineaAlquilerListNewLineaAlquiler = em.merge(lineaAlquilerListNewLineaAlquiler);
                    if (oldRutaOfLineaAlquilerListNewLineaAlquiler != null && !oldRutaOfLineaAlquilerListNewLineaAlquiler.equals(ruta)) {
                        oldRutaOfLineaAlquilerListNewLineaAlquiler.getLineaAlquilerList().remove(lineaAlquilerListNewLineaAlquiler);
                        oldRutaOfLineaAlquilerListNewLineaAlquiler = em.merge(oldRutaOfLineaAlquilerListNewLineaAlquiler);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ruta.getCodrut();
                if (findRuta(id) == null) {
                    throw new NonexistentEntityException("The ruta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ruta ruta;
            try {
                ruta = em.getReference(Ruta.class, id);
                ruta.getCodrut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ruta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LineaAlquiler> lineaAlquilerListOrphanCheck = ruta.getLineaAlquilerList();
            for (LineaAlquiler lineaAlquilerListOrphanCheckLineaAlquiler : lineaAlquilerListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ruta (" + ruta + ") cannot be destroyed since the LineaAlquiler " + lineaAlquilerListOrphanCheckLineaAlquiler + " in its lineaAlquilerList field has a non-nullable ruta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ruta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ruta> findRutaEntities() {
        return findRutaEntities(true, -1, -1);
    }

    public List<Ruta> findRutaEntities(int maxResults, int firstResult) {
        return findRutaEntities(false, maxResults, firstResult);
    }

    private List<Ruta> findRutaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ruta.class));
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

    public Ruta findRuta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ruta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ruta> rt = cq.from(Ruta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

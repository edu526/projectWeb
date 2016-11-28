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
 * @author Miriam
 */
public class AlquilerJpaController implements Serializable {

    public AlquilerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public AlquilerJpaController() {
        emf=Persistence.createEntityManagerFactory("AlquilerEmpPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alquiler alquiler) throws PreexistingEntityException, Exception {
        if (alquiler.getLineaAlquilerList() == null) {
            alquiler.setLineaAlquilerList(new ArrayList<LineaAlquiler>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado codemp = alquiler.getCodemp();
            if (codemp != null) {
                codemp = em.getReference(codemp.getClass(), codemp.getCodemp());
                alquiler.setCodemp(codemp);
            }
            Vehiculo codveh = alquiler.getCodveh();
            if (codveh != null) {
                codveh = em.getReference(codveh.getClass(), codveh.getCodveh());
                alquiler.setCodveh(codveh);
            }
            List<LineaAlquiler> attachedLineaAlquilerList = new ArrayList<LineaAlquiler>();
            for (LineaAlquiler lineaAlquilerListLineaAlquilerToAttach : alquiler.getLineaAlquilerList()) {
                lineaAlquilerListLineaAlquilerToAttach = em.getReference(lineaAlquilerListLineaAlquilerToAttach.getClass(), lineaAlquilerListLineaAlquilerToAttach.getLineaAlquilerPK());
                attachedLineaAlquilerList.add(lineaAlquilerListLineaAlquilerToAttach);
            }
            alquiler.setLineaAlquilerList(attachedLineaAlquilerList);
            em.persist(alquiler);
            if (codemp != null) {
                codemp.getAlquilerList().add(alquiler);
                codemp = em.merge(codemp);
            }
            if (codveh != null) {
                codveh.getAlquilerList().add(alquiler);
                codveh = em.merge(codveh);
            }
            for (LineaAlquiler lineaAlquilerListLineaAlquiler : alquiler.getLineaAlquilerList()) {
                Alquiler oldAlquilerOfLineaAlquilerListLineaAlquiler = lineaAlquilerListLineaAlquiler.getAlquiler();
                lineaAlquilerListLineaAlquiler.setAlquiler(alquiler);
                lineaAlquilerListLineaAlquiler = em.merge(lineaAlquilerListLineaAlquiler);
                if (oldAlquilerOfLineaAlquilerListLineaAlquiler != null) {
                    oldAlquilerOfLineaAlquilerListLineaAlquiler.getLineaAlquilerList().remove(lineaAlquilerListLineaAlquiler);
                    oldAlquilerOfLineaAlquilerListLineaAlquiler = em.merge(oldAlquilerOfLineaAlquilerListLineaAlquiler);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlquiler(alquiler.getNumalq()) != null) {
                throw new PreexistingEntityException("Alquiler " + alquiler + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alquiler alquiler) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alquiler persistentAlquiler = em.find(Alquiler.class, alquiler.getNumalq());
            Empleado codempOld = persistentAlquiler.getCodemp();
            Empleado codempNew = alquiler.getCodemp();
            Vehiculo codvehOld = persistentAlquiler.getCodveh();
            Vehiculo codvehNew = alquiler.getCodveh();
            List<LineaAlquiler> lineaAlquilerListOld = persistentAlquiler.getLineaAlquilerList();
            List<LineaAlquiler> lineaAlquilerListNew = alquiler.getLineaAlquilerList();
            List<String> illegalOrphanMessages = null;
            for (LineaAlquiler lineaAlquilerListOldLineaAlquiler : lineaAlquilerListOld) {
                if (!lineaAlquilerListNew.contains(lineaAlquilerListOldLineaAlquiler)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LineaAlquiler " + lineaAlquilerListOldLineaAlquiler + " since its alquiler field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempNew != null) {
                codempNew = em.getReference(codempNew.getClass(), codempNew.getCodemp());
                alquiler.setCodemp(codempNew);
            }
            if (codvehNew != null) {
                codvehNew = em.getReference(codvehNew.getClass(), codvehNew.getCodveh());
                alquiler.setCodveh(codvehNew);
            }
            List<LineaAlquiler> attachedLineaAlquilerListNew = new ArrayList<LineaAlquiler>();
            for (LineaAlquiler lineaAlquilerListNewLineaAlquilerToAttach : lineaAlquilerListNew) {
                lineaAlquilerListNewLineaAlquilerToAttach = em.getReference(lineaAlquilerListNewLineaAlquilerToAttach.getClass(), lineaAlquilerListNewLineaAlquilerToAttach.getLineaAlquilerPK());
                attachedLineaAlquilerListNew.add(lineaAlquilerListNewLineaAlquilerToAttach);
            }
            lineaAlquilerListNew = attachedLineaAlquilerListNew;
            alquiler.setLineaAlquilerList(lineaAlquilerListNew);
            alquiler = em.merge(alquiler);
            if (codempOld != null && !codempOld.equals(codempNew)) {
                codempOld.getAlquilerList().remove(alquiler);
                codempOld = em.merge(codempOld);
            }
            if (codempNew != null && !codempNew.equals(codempOld)) {
                codempNew.getAlquilerList().add(alquiler);
                codempNew = em.merge(codempNew);
            }
            if (codvehOld != null && !codvehOld.equals(codvehNew)) {
                codvehOld.getAlquilerList().remove(alquiler);
                codvehOld = em.merge(codvehOld);
            }
            if (codvehNew != null && !codvehNew.equals(codvehOld)) {
                codvehNew.getAlquilerList().add(alquiler);
                codvehNew = em.merge(codvehNew);
            }
            for (LineaAlquiler lineaAlquilerListNewLineaAlquiler : lineaAlquilerListNew) {
                if (!lineaAlquilerListOld.contains(lineaAlquilerListNewLineaAlquiler)) {
                    Alquiler oldAlquilerOfLineaAlquilerListNewLineaAlquiler = lineaAlquilerListNewLineaAlquiler.getAlquiler();
                    lineaAlquilerListNewLineaAlquiler.setAlquiler(alquiler);
                    lineaAlquilerListNewLineaAlquiler = em.merge(lineaAlquilerListNewLineaAlquiler);
                    if (oldAlquilerOfLineaAlquilerListNewLineaAlquiler != null && !oldAlquilerOfLineaAlquilerListNewLineaAlquiler.equals(alquiler)) {
                        oldAlquilerOfLineaAlquilerListNewLineaAlquiler.getLineaAlquilerList().remove(lineaAlquilerListNewLineaAlquiler);
                        oldAlquilerOfLineaAlquilerListNewLineaAlquiler = em.merge(oldAlquilerOfLineaAlquilerListNewLineaAlquiler);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = alquiler.getNumalq();
                if (findAlquiler(id) == null) {
                    throw new NonexistentEntityException("The alquiler with id " + id + " no longer exists.");
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
            Alquiler alquiler;
            try {
                alquiler = em.getReference(Alquiler.class, id);
                alquiler.getNumalq();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alquiler with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LineaAlquiler> lineaAlquilerListOrphanCheck = alquiler.getLineaAlquilerList();
            for (LineaAlquiler lineaAlquilerListOrphanCheckLineaAlquiler : lineaAlquilerListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alquiler (" + alquiler + ") cannot be destroyed since the LineaAlquiler " + lineaAlquilerListOrphanCheckLineaAlquiler + " in its lineaAlquilerList field has a non-nullable alquiler field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado codemp = alquiler.getCodemp();
            if (codemp != null) {
                codemp.getAlquilerList().remove(alquiler);
                codemp = em.merge(codemp);
            }
            Vehiculo codveh = alquiler.getCodveh();
            if (codveh != null) {
                codveh.getAlquilerList().remove(alquiler);
                codveh = em.merge(codveh);
            }
            em.remove(alquiler);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alquiler> findAlquilerEntities() {
        return findAlquilerEntities(true, -1, -1);
    }

    public List<Alquiler> findAlquilerEntities(int maxResults, int firstResult) {
        return findAlquilerEntities(false, maxResults, firstResult);
    }

    private List<Alquiler> findAlquilerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alquiler.class));
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

    public Alquiler findAlquiler(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alquiler.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlquilerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alquiler> rt = cq.from(Alquiler.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

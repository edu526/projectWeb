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
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author edd
 */
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
public VehiculoJpaController() {
        
        this.emf = Persistence.createEntityManagerFactory("AlquilerPU");
    }
    public void create(Vehiculo vehiculo) throws PreexistingEntityException, Exception {
        if (vehiculo.getAlquilerList() == null) {
            vehiculo.setAlquilerList(new ArrayList<Alquiler>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado codemp = vehiculo.getCodemp();
            if (codemp != null) {
                codemp = em.getReference(codemp.getClass(), codemp.getCodemp());
                vehiculo.setCodemp(codemp);
            }
            List<Alquiler> attachedAlquilerList = new ArrayList<Alquiler>();
            for (Alquiler alquilerListAlquilerToAttach : vehiculo.getAlquilerList()) {
                alquilerListAlquilerToAttach = em.getReference(alquilerListAlquilerToAttach.getClass(), alquilerListAlquilerToAttach.getNumalq());
                attachedAlquilerList.add(alquilerListAlquilerToAttach);
            }
            vehiculo.setAlquilerList(attachedAlquilerList);
            em.persist(vehiculo);
            if (codemp != null) {
                codemp.getVehiculoList().add(vehiculo);
                codemp = em.merge(codemp);
            }
            for (Alquiler alquilerListAlquiler : vehiculo.getAlquilerList()) {
                Vehiculo oldCodvehOfAlquilerListAlquiler = alquilerListAlquiler.getCodveh();
                alquilerListAlquiler.setCodveh(vehiculo);
                alquilerListAlquiler = em.merge(alquilerListAlquiler);
                if (oldCodvehOfAlquilerListAlquiler != null) {
                    oldCodvehOfAlquilerListAlquiler.getAlquilerList().remove(alquilerListAlquiler);
                    oldCodvehOfAlquilerListAlquiler = em.merge(oldCodvehOfAlquilerListAlquiler);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVehiculo(vehiculo.getCodveh()) != null) {
                throw new PreexistingEntityException("Vehiculo " + vehiculo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getCodveh());
            Empleado codempOld = persistentVehiculo.getCodemp();
            Empleado codempNew = vehiculo.getCodemp();
            List<Alquiler> alquilerListOld = persistentVehiculo.getAlquilerList();
            List<Alquiler> alquilerListNew = vehiculo.getAlquilerList();
            if (codempNew != null) {
                codempNew = em.getReference(codempNew.getClass(), codempNew.getCodemp());
                vehiculo.setCodemp(codempNew);
            }
            List<Alquiler> attachedAlquilerListNew = new ArrayList<Alquiler>();
            for (Alquiler alquilerListNewAlquilerToAttach : alquilerListNew) {
                alquilerListNewAlquilerToAttach = em.getReference(alquilerListNewAlquilerToAttach.getClass(), alquilerListNewAlquilerToAttach.getNumalq());
                attachedAlquilerListNew.add(alquilerListNewAlquilerToAttach);
            }
            alquilerListNew = attachedAlquilerListNew;
            vehiculo.setAlquilerList(alquilerListNew);
            vehiculo = em.merge(vehiculo);
            if (codempOld != null && !codempOld.equals(codempNew)) {
                codempOld.getVehiculoList().remove(vehiculo);
                codempOld = em.merge(codempOld);
            }
            if (codempNew != null && !codempNew.equals(codempOld)) {
                codempNew.getVehiculoList().add(vehiculo);
                codempNew = em.merge(codempNew);
            }
            for (Alquiler alquilerListOldAlquiler : alquilerListOld) {
                if (!alquilerListNew.contains(alquilerListOldAlquiler)) {
                    alquilerListOldAlquiler.setCodveh(null);
                    alquilerListOldAlquiler = em.merge(alquilerListOldAlquiler);
                }
            }
            for (Alquiler alquilerListNewAlquiler : alquilerListNew) {
                if (!alquilerListOld.contains(alquilerListNewAlquiler)) {
                    Vehiculo oldCodvehOfAlquilerListNewAlquiler = alquilerListNewAlquiler.getCodveh();
                    alquilerListNewAlquiler.setCodveh(vehiculo);
                    alquilerListNewAlquiler = em.merge(alquilerListNewAlquiler);
                    if (oldCodvehOfAlquilerListNewAlquiler != null && !oldCodvehOfAlquilerListNewAlquiler.equals(vehiculo)) {
                        oldCodvehOfAlquilerListNewAlquiler.getAlquilerList().remove(alquilerListNewAlquiler);
                        oldCodvehOfAlquilerListNewAlquiler = em.merge(oldCodvehOfAlquilerListNewAlquiler);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vehiculo.getCodveh();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getCodveh();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            Empleado codemp = vehiculo.getCodemp();
            if (codemp != null) {
                codemp.getVehiculoList().remove(vehiculo);
                codemp = em.merge(codemp);
            }
            List<Alquiler> alquilerList = vehiculo.getAlquilerList();
            for (Alquiler alquilerListAlquiler : alquilerList) {
                alquilerListAlquiler.setCodveh(null);
                alquilerListAlquiler = em.merge(alquilerListAlquiler);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

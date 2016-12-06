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
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author edd
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, Exception {
        if (empleado.getAlquilerList() == null) {
            empleado.setAlquilerList(new ArrayList<Alquiler>());
        }
        if (empleado.getVehiculoList() == null) {
            empleado.setVehiculoList(new ArrayList<Vehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Alquiler> attachedAlquilerList = new ArrayList<Alquiler>();
            for (Alquiler alquilerListAlquilerToAttach : empleado.getAlquilerList()) {
                alquilerListAlquilerToAttach = em.getReference(alquilerListAlquilerToAttach.getClass(), alquilerListAlquilerToAttach.getNumalq());
                attachedAlquilerList.add(alquilerListAlquilerToAttach);
            }
            empleado.setAlquilerList(attachedAlquilerList);
            List<Vehiculo> attachedVehiculoList = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculoListVehiculoToAttach : empleado.getVehiculoList()) {
                vehiculoListVehiculoToAttach = em.getReference(vehiculoListVehiculoToAttach.getClass(), vehiculoListVehiculoToAttach.getCodveh());
                attachedVehiculoList.add(vehiculoListVehiculoToAttach);
            }
            empleado.setVehiculoList(attachedVehiculoList);
            em.persist(empleado);
            for (Alquiler alquilerListAlquiler : empleado.getAlquilerList()) {
                Empleado oldCodempOfAlquilerListAlquiler = alquilerListAlquiler.getCodemp();
                alquilerListAlquiler.setCodemp(empleado);
                alquilerListAlquiler = em.merge(alquilerListAlquiler);
                if (oldCodempOfAlquilerListAlquiler != null) {
                    oldCodempOfAlquilerListAlquiler.getAlquilerList().remove(alquilerListAlquiler);
                    oldCodempOfAlquilerListAlquiler = em.merge(oldCodempOfAlquilerListAlquiler);
                }
            }
            for (Vehiculo vehiculoListVehiculo : empleado.getVehiculoList()) {
                Empleado oldCodempOfVehiculoListVehiculo = vehiculoListVehiculo.getCodemp();
                vehiculoListVehiculo.setCodemp(empleado);
                vehiculoListVehiculo = em.merge(vehiculoListVehiculo);
                if (oldCodempOfVehiculoListVehiculo != null) {
                    oldCodempOfVehiculoListVehiculo.getVehiculoList().remove(vehiculoListVehiculo);
                    oldCodempOfVehiculoListVehiculo = em.merge(oldCodempOfVehiculoListVehiculo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleado(empleado.getCodemp()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getCodemp());
            List<Alquiler> alquilerListOld = persistentEmpleado.getAlquilerList();
            List<Alquiler> alquilerListNew = empleado.getAlquilerList();
            List<Vehiculo> vehiculoListOld = persistentEmpleado.getVehiculoList();
            List<Vehiculo> vehiculoListNew = empleado.getVehiculoList();
            List<Alquiler> attachedAlquilerListNew = new ArrayList<Alquiler>();
            for (Alquiler alquilerListNewAlquilerToAttach : alquilerListNew) {
                alquilerListNewAlquilerToAttach = em.getReference(alquilerListNewAlquilerToAttach.getClass(), alquilerListNewAlquilerToAttach.getNumalq());
                attachedAlquilerListNew.add(alquilerListNewAlquilerToAttach);
            }
            alquilerListNew = attachedAlquilerListNew;
            empleado.setAlquilerList(alquilerListNew);
            List<Vehiculo> attachedVehiculoListNew = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculoListNewVehiculoToAttach : vehiculoListNew) {
                vehiculoListNewVehiculoToAttach = em.getReference(vehiculoListNewVehiculoToAttach.getClass(), vehiculoListNewVehiculoToAttach.getCodveh());
                attachedVehiculoListNew.add(vehiculoListNewVehiculoToAttach);
            }
            vehiculoListNew = attachedVehiculoListNew;
            empleado.setVehiculoList(vehiculoListNew);
            empleado = em.merge(empleado);
            for (Alquiler alquilerListOldAlquiler : alquilerListOld) {
                if (!alquilerListNew.contains(alquilerListOldAlquiler)) {
                    alquilerListOldAlquiler.setCodemp(null);
                    alquilerListOldAlquiler = em.merge(alquilerListOldAlquiler);
                }
            }
            for (Alquiler alquilerListNewAlquiler : alquilerListNew) {
                if (!alquilerListOld.contains(alquilerListNewAlquiler)) {
                    Empleado oldCodempOfAlquilerListNewAlquiler = alquilerListNewAlquiler.getCodemp();
                    alquilerListNewAlquiler.setCodemp(empleado);
                    alquilerListNewAlquiler = em.merge(alquilerListNewAlquiler);
                    if (oldCodempOfAlquilerListNewAlquiler != null && !oldCodempOfAlquilerListNewAlquiler.equals(empleado)) {
                        oldCodempOfAlquilerListNewAlquiler.getAlquilerList().remove(alquilerListNewAlquiler);
                        oldCodempOfAlquilerListNewAlquiler = em.merge(oldCodempOfAlquilerListNewAlquiler);
                    }
                }
            }
            for (Vehiculo vehiculoListOldVehiculo : vehiculoListOld) {
                if (!vehiculoListNew.contains(vehiculoListOldVehiculo)) {
                    vehiculoListOldVehiculo.setCodemp(null);
                    vehiculoListOldVehiculo = em.merge(vehiculoListOldVehiculo);
                }
            }
            for (Vehiculo vehiculoListNewVehiculo : vehiculoListNew) {
                if (!vehiculoListOld.contains(vehiculoListNewVehiculo)) {
                    Empleado oldCodempOfVehiculoListNewVehiculo = vehiculoListNewVehiculo.getCodemp();
                    vehiculoListNewVehiculo.setCodemp(empleado);
                    vehiculoListNewVehiculo = em.merge(vehiculoListNewVehiculo);
                    if (oldCodempOfVehiculoListNewVehiculo != null && !oldCodempOfVehiculoListNewVehiculo.equals(empleado)) {
                        oldCodempOfVehiculoListNewVehiculo.getVehiculoList().remove(vehiculoListNewVehiculo);
                        oldCodempOfVehiculoListNewVehiculo = em.merge(oldCodempOfVehiculoListNewVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empleado.getCodemp();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getCodemp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<Alquiler> alquilerList = empleado.getAlquilerList();
            for (Alquiler alquilerListAlquiler : alquilerList) {
                alquilerListAlquiler.setCodemp(null);
                alquilerListAlquiler = em.merge(alquilerListAlquiler);
            }
            List<Vehiculo> vehiculoList = empleado.getVehiculoList();
            for (Vehiculo vehiculoListVehiculo : vehiculoList) {
                vehiculoListVehiculo.setCodemp(null);
                vehiculoListVehiculo = em.merge(vehiculoListVehiculo);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

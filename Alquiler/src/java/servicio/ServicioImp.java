/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.swing.JOptionPane;
import negocio.AlquilerObj;
import negocio.EmpleadoObj;
import negocio.RutaObj;
import negocio.VehiculoObj;
import persistencia.Datos;
import persistencia.Empleado;
import persistencia.Ruta;
import persistencia.Vehiculo;

/**
 *
 * @author edd
 */
public class ServicioImp implements Servicio {

    private AlquilerObj alqObj;
    private Datos dat;

    public void setDat(Datos dat) {
        this.dat = dat;
    }

    @Override
    public AlquilerObj nuevoAlquiler() {
        alqObj = new AlquilerObj();
        return alqObj;
    }

    @Override
    public String grabar() {
        JOptionPane.showMessageDialog(null, "Nivel Servicio "+alqObj.getNumAlq());
        boolean es = dat.grabarAlquiler(alqObj.getNumAlq(), 
                alqObj.getFecAlq(), 
                alqObj.getEstadAlq(), 
                alqObj.getCodEmp().getCodEmp(), 
                alqObj.getCodVeh().getCodVeh(), 
                alqObj.getTotal(),
                alqObj.getDesct());        
        
        if (es) {
            return dat.grabarDetalle(alqObj.getNumAlq(), alqObj.getLinObj().getCodRut().getCodRut());
        }
        
       return "Fallo al grabar";
    }

    @Override
    public void agregarVeh(String cod) {
        VehiculoObj v = new VehiculoObj();
        Vehiculo ve = dat.buscarVeh(cod);

        v.setAnioVeh(ve.getAnioveh());

        Empleado emp = ve.getCodemp();
        EmpleadoObj empObj = new EmpleadoObj();
        empObj.setCodEmp(emp.getCodemp());
        empObj.setNomEmp(emp.getNomemp());
        empObj.setApeEmp(emp.getApeemp());
        empObj.setDirEmp(emp.getDiremp());
        empObj.setDniEmp(emp.getDniemp());
        empObj.setLicCon(emp.getLiccon());
        empObj.setTelEmp(emp.getTelemp());
        empObj.setSeguroEmp(emp.getSeguroemp());
        empObj.setEmailEmp(emp.getEmailemp());

        v.setCodEmp(empObj);
        v.setCodVeh(ve.getCodveh());
        v.setEstadVeh(ve.getEstadveh());
        v.setMatricuVeh(ve.getMatricuveh());
        v.setModelVeh(ve.getModelveh());
        v.setMotorVeh(ve.getMotorveh());
        v.setNFlota(ve.getNflota());
        v.setPrecVeh(ve.getPrecveh());
        v.setSerieVeh(ve.getSerieveh());
        v.setTipoVeh(ve.getTipoveh());

        alqObj.setCodVeh(v);
    }

    @Override
    public void agregarRut(String cod) {
        Ruta r = dat.buscarRut(cod);
        RutaObj ru = new RutaObj();

        ru.setCodRut(r.getCodrut());
        ru.setParadAut(r.getParadaut());
        ru.setPrecRut(r.getPrecrut());
        alqObj.setLinObj(ru);
    }

}

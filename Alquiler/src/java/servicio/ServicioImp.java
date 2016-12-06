/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import negocio.AlquilerObj;
import negocio.EmpleadoObj;
import negocio.LineaObj;
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
        AlquilerObj.d.clear();
        return alqObj;
    }

    @Override
    public String grabar() {
        boolean es = dat.grabarAlquiler(alqObj.getNumAlq(),
                alqObj.getFecAlq(),
                alqObj.getEstadAlq(),
                alqObj.getCodEmp().getCodEmp(),
                alqObj.getCodVeh().getCodVeh(),
                alqObj.getTotal(),
                alqObj.getHora(),
                alqObj.getDesct());
        if (es) {
            for (int i = 0; i < alqObj.getCesta().size(); i++) {
                LineaObj lin = (LineaObj) alqObj.getCesta().get(i);
                dat.grabarDetalle(lin.getNumAlq(), lin.getCodRut().getCodRut(), lin.getDia());
            }
            
            return "Proceso Satisfactorio";
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
    public void agregarRut(String cod, String dia) {
        Ruta r = dat.buscarRut(cod);
        RutaObj ru = new RutaObj();

        ru.setCodRut(r.getCodrut());
        ru.setParadAut(r.getParadaut());
        ru.setPrecRut(r.getPrecrut());
        alqObj.agregarLinea(ru, dia);
    }

    @Override
    public void quitarRuta(String dia) {
        alqObj.quitarLinea(dia);
    }

}

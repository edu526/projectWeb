/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import persistencia.Datos;
import persistencia.Empleado;
import persistencia.Ruta;
import persistencia.Vehiculo;

/**
 *
 * @author Miriam
 */
public class ServicioImp implements Servicio{
    private Datos dat;

    public void setDat(Datos dat) {
        this.dat = dat;
    }
    
    @Override
    public String grabarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp) {
        return dat.grabarEmp(codEmp, nomEmp, apeEmp, dirEmp, dniEmp, licCon, telEmp, seguroEmp, emailEmp);
    }

    @Override
    public Empleado buscarEmp(String codEmp) {
        return dat.buscarEmp(codEmp);
    }

    @Override
    public String actualizarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp) {
        return dat.actualizarEmp(codEmp, nomEmp, apeEmp, dirEmp, dniEmp, licCon, telEmp, seguroEmp, emailEmp);
    }

    @Override
    public String grabarVeh(String codVeh, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh) {
        return dat.grabarVeh(codVeh, matricuVeh, modelVeh, motorVeh, serieVeh, anioVeh, estadVeh, tipoVeh, precVeh);
    }

    @Override
    public Vehiculo buscarVeh(String codVeh) {
        return dat.buscarVeh(codVeh);
    }

    @Override
    public String actualizarVeh(String codVeh, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh) {
        return dat.actualizarVeh(codVeh, matricuVeh, modelVeh, motorVeh, serieVeh, anioVeh, estadVeh, tipoVeh, precVeh);
    }

    @Override
    public String grabarRut(String codRut, String origRut, String destRut, String paradAut, double precRut) {
        return dat.grabarRut(codRut, origRut, destRut, paradAut, precRut);
    }

    @Override
    public Ruta buscarRut(String codRut) {
        return dat.buscarRut(codRut);
    }

    @Override
    public String actualizarRut(String codRut, String origRut, String destRut, String paradAut, double precRut) {
        return dat.actualizarRut(codRut, origRut, destRut, paradAut, precRut);
    }


    
}

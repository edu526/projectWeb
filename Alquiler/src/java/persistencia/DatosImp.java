/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Miriam
 */
public class DatosImp implements Datos {
    private Alquiler alq;
    private AlquilerJpaController alqCon;
    private Empleado emp;
    private EmpleadoJpaController empCon;
    private LineaAlquiler lin;
    private LineaAlquilerJpaController linCon;
    private LineaAlquilerPK linPK;
    private Ruta rut;
    private RutaJpaController rutCon;
    private Vehiculo veh;
    private VehiculoJpaController vehCon;

    public void setAlq(Alquiler alq) {
        this.alq = alq;
    }

    public void setAlqCon(AlquilerJpaController alqCon) {
        this.alqCon = alqCon;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public void setEmpCon(EmpleadoJpaController empCon) {
        this.empCon = empCon;
    }

    public void setLin(LineaAlquiler lin) {
        this.lin = lin;
    }

    public void setLinCon(LineaAlquilerJpaController linCon) {
        this.linCon = linCon;
    }

    public void setLinPK(LineaAlquilerPK linPK) {
        this.linPK = linPK;
    }

    public void setRut(Ruta rut) {
        this.rut = rut;
    }

    public void setRutCon(RutaJpaController rutCon) {
        this.rutCon = rutCon;
    }

    public void setVeh(Vehiculo veh) {
        this.veh = veh;
    }

    public void setVehCon(VehiculoJpaController vehCon) {
        this.vehCon = vehCon;
    }

    
    @Override
    public String grabarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp) {
        emp.setCodemp(codEmp);
        emp.setNomemp(nomEmp);
        emp.setApeemp(apeEmp);
        emp.setDiremp(dirEmp);
        emp.setDniemp(dirEmp);
        emp.setLiccon(licCon);
        emp.setTelemp(telEmp);
        emp.setSeguroemp(seguroEmp);
        emp.setEmailemp(emailEmp);
        try {
            empCon.create(emp);
        } catch (Exception e) {
        return e.getMessage();
        } return "Empleado Grabado Correctamente";
        
    }

    @Override
    public Empleado buscarEmp(String codEmp) {
      
          return  empCon.findEmpleado(codEmp);
    
    }

    @Override
    public String actualizarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp) {
        emp.setCodemp(codEmp);
        emp.setNomemp(nomEmp);
        emp.setApeemp(apeEmp);
        emp.setDiremp(dirEmp);
        emp.setDniemp(dirEmp);
        emp.setLiccon(licCon);
        emp.setTelemp(telEmp);
        emp.setSeguroemp(seguroEmp);
        emp.setEmailemp(emailEmp);
        try {
            empCon.edit(emp);
        } catch (Exception e) {
            return e.getMessage();
        } return "Datos Actualizados! Empleado "+" "+nomEmp+"";
    }

    @Override
    public String grabarVeh(String codVeh, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh) {
        veh.setCodveh(codVeh);
        veh.setMatricuveh(matricuVeh);
        veh.setModelveh(modelVeh);
        veh.setMotorveh(motorVeh);
        veh.setSerieveh(serieVeh);
        veh.setAnioveh(anioVeh);
        veh.setEstadveh(estadVeh);
        veh.setTipoveh(tipoVeh);
        veh.setPrecveh(precVeh);
        try {
            vehCon.create(veh);
        } catch (Exception e) {
            return e.getMessage();
        } return "Vehiculo Registrado!";
    }

    @Override
    public Vehiculo buscarVeh(String codVeh) {
        return vehCon.findVehiculo(codVeh);
    }

    @Override
    public String actualizarVeh(String codVeh, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh) {
        
            veh.setCodveh(codVeh);
        veh.setMatricuveh(matricuVeh);
        veh.setModelveh(modelVeh);
        veh.setMotorveh(motorVeh);
        veh.setSerieveh(serieVeh);
        veh.setAnioveh(anioVeh);
        veh.setEstadveh(estadVeh);
        veh.setTipoveh(tipoVeh);
        veh.setPrecveh(precVeh);
        try {
            vehCon.edit(veh);
        } catch (Exception e) {
            return e.getMessage();
        } return "Vehiculo Actualizado!";
    }

    @Override
    public String grabarRut(String codRut, String origRut, String destRut, String paradAut, double precRut) {
        rut.setCodrut(codRut);
        rut.setOrigrut(origRut);
        rut.setDestrut(destRut);
        rut.setParadaut(paradAut);
        rut.setPrecrut(precRut);
        try {
            rutCon.create(rut);
        } catch (Exception e) {
            e.getMessage();
        } return "Ruta Grabada";
    }

    @Override
    public Ruta buscarRut(String codRut) {
        return rutCon.findRuta(codRut);
    }

    @Override
    public String actualizarRut(String codRut, String origRut, String destRut, String paradAut, double precRut) {
                rut.setCodrut(codRut);
        rut.setOrigrut(origRut);
        rut.setDestrut(destRut);
        rut.setParadaut(paradAut);
        rut.setPrecrut(precRut);
        try {
            rutCon.edit(rut);
        } catch (Exception e) {
            e.getMessage();
        } return "Ruta Actualizada";
    
    }


    
    
}

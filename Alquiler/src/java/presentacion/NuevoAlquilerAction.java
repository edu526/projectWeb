/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.AlquilerObj;
import negocio.EmpleadoObj;
import negocio.RutaObj;
import negocio.VehiculoObj;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.Datos;
import persistencia.Empleado;
import servicio.Servicio;

/**
 *
 * @author edd
 */
public class NuevoAlquilerAction extends org.apache.struts.action.Action {
    
    private Servicio ser;
    private Datos dat;
    
    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    public void setDat(Datos dat) {
        this.dat = dat;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        NuevoAlquilerForm x = (NuevoAlquilerForm) form;
        
        Empleado emp = dat.buscarEmp(x.getCodEmp());
        
        if (emp != null) {
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
            
            AlquilerObj alqObj = ser.nuevoAlquiler();
            VehiculoObj v = new VehiculoObj();
            RutaObj r = new RutaObj();
            
            alqObj.setCodEmp(empObj);
            alqObj.setNumAlq(dat.getNumAlq());
            alqObj.setCodVeh(v);
            alqObj.setLinObj(r);
            alqObj.setEstadAlq("");
            
            request.getSession().setAttribute("alqObj", alqObj);
            return mapping.findForward("Alquiler");
        } else {
            request.getSession().setAttribute("msg", "El empleado no se encuentra registrado");
            return mapping.findForward("Mensaje");
        }
    }
}

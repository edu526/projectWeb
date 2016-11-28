/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.Empleado;
import servicios.Servicio;

/**
 *
 * @author Miriam
 */
public class BuscarEmpAction extends org.apache.struts.action.Action {

   private Servicio ser;

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
   
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        BuscarEmpForm x=(BuscarEmpForm) form;
        Empleado e=ser.buscarEmp(x.getCodEmp());
        if (e!=null){
            request.getSession().setAttribute("e", e);
                return mapping.findForward("Actualizar");
            }
        else{
        request.getSession().setAttribute("msg","No existe Empleado");
        return mapping.findForward("Mensaje");
    }}
}

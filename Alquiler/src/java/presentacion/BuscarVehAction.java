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
import persistencia.Vehiculo;
import servicios.Servicio;

/**
 *
 * @author Miriam
 */
public class BuscarVehAction extends org.apache.struts.action.Action {

    private Servicio ser;

    public Servicio getSer() {
        return ser;
    }

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
   
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        BuscarVehForm x=(BuscarVehForm) form;
        Vehiculo v=ser.buscarVeh(x.getCodVeh());
  if (v!=null){
            request.getSession().setAttribute("v", v);
                return mapping.findForward("Actualizar");
            }
        else{
        request.getSession().setAttribute("msg","No existe VEHICULO");
        return mapping.findForward("Mensaje");
    }}
}

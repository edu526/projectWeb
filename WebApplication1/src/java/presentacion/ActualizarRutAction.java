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
import servicios.Servicio;

/**
 *
 * @author Miriam
 */
public class ActualizarRutAction extends org.apache.struts.action.Action {

    private Servicio ser;

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActualizarRutForm x=(ActualizarRutForm) form;
        request.getSession().setAttribute("msg",ser.actualizarRut(x.getCodRut(), x.getOrigRut(), x.getDestRut(), x.getParadAut(), x.getPrecRut()));
        return mapping.findForward("Mensaje");
    }
}

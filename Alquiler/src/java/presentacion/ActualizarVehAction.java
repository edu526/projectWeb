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
public class ActualizarVehAction extends org.apache.struts.action.Action {

    private Servicio ser;

    

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActualizarVehForm x=(ActualizarVehForm) form;
        request.getSession().setAttribute("msg",ser.actualizarVeh(x.getCodVeh(), x.getMatricuVeh(), x.getModelVeh(),x.getMotorVeh(), x.getSerieVeh(), x.getAnioVeh(), x.getEstadVeh(), x.getTipoVeh(), x.getPrecVeh()));
        return mapping.findForward("Mensaje");
    }
}
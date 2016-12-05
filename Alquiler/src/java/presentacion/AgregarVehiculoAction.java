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
import servicio.Servicio;

/**
 *
 * @author edd
 */
public class AgregarVehiculoAction extends org.apache.struts.action.Action {

    private Servicio ser;

    public void setSer(Servicio ser) {
        this.ser = ser;
    }
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        AgregarVehiculoForm x = (AgregarVehiculoForm) form;
        
        ser.agregarVeh(x.getCod());
        return mapping.findForward("Alquilar");
    }
}

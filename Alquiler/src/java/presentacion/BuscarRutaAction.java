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
import persistencia.Datos;

/**
 *
 * @author edd
 */
public class BuscarRutaAction extends org.apache.struts.action.Action {

    private Datos dat;

    public void setDat(Datos dat) {
        this.dat = dat;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        request.getSession().setAttribute("rutList", dat.listarRutas());
        
        return mapping.findForward("Listar");
    }


}

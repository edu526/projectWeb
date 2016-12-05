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
 * @author Miriam
 */
public class GrabarEmpAction extends org.apache.struts.action.Action {

    private Datos dat;

    public void setDat(Datos dat) {
        this.dat = dat;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        GrabarEmpForm x = (GrabarEmpForm) form;
        
        String msg = dat.grabarEmp(x.getCodEmp(), 
                x.getNomEmp(), 
                x.getApeEmp(), 
                x.getDirEmp(), 
                x.getDniEmp(), 
                x.getLicCon(), 
                x.getTelEmp(), 
                x.getSeguroEmp(), 
                x.getEmailEmp());
        
        request.getSession().setAttribute("msg", msg);
        return mapping.findForward("Mensaje");
    }
}

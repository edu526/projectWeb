/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Miriam
 */
public class GrabarRutForm extends org.apache.struts.action.ActionForm {
    
    private String codRut, origRut, destRut, paradAut;
    private double precRut;

    public String getCodRut() {
        return codRut;
    }

    public void setCodRut(String codRut) {
        this.codRut = codRut;
    }

    public String getOrigRut() {
        return origRut;
    }

    public void setOrigRut(String origRut) {
        this.origRut = origRut;
    }

    public String getDestRut() {
        return destRut;
    }

    public void setDestRut(String destRut) {
        this.destRut = destRut;
    }

    public String getParadAut() {
        return paradAut;
    }

    public void setParadAut(String paradAut) {
        this.paradAut = paradAut;
    }

    public double getPrecRut() {
        return precRut;
    }

    public void setPrecRut(double precRut) {
        this.precRut = precRut;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getCodRut() == null || getCodRut().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}

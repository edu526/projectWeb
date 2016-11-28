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
public class GrabarVehForm extends org.apache.struts.action.ActionForm {
    
    private String codVeh, matricuVeh, modelVeh, motorVeh, serieVeh, anioVeh, estadVeh, tipoVeh; 
    private double precVeh;

    public double getPrecVeh() {
        return precVeh;
    }

    public void setPrecVeh(double precVeh) {
        this.precVeh = precVeh;
    }

    public String getCodVeh() {
        return codVeh;
    }

    public void setCodVeh(String codVeh) {
        this.codVeh = codVeh;
    }

    public String getMatricuVeh() {
        return matricuVeh;
    }

    public void setMatricuVeh(String matricuVeh) {
        this.matricuVeh = matricuVeh;
    }

    public String getModelVeh() {
        return modelVeh;
    }

    public void setModelVeh(String modelVeh) {
        this.modelVeh = modelVeh;
    }

    public String getMotorVeh() {
        return motorVeh;
    }

    public void setMotorVeh(String motorVeh) {
        this.motorVeh = motorVeh;
    }

    public String getSerieVeh() {
        return serieVeh;
    }

    public void setSerieVeh(String serieVeh) {
        this.serieVeh = serieVeh;
    }

    public String getAnioVeh() {
        return anioVeh;
    }

    public void setAnioVeh(String anioVeh) {
        this.anioVeh = anioVeh;
    }

    public String getEstadVeh() {
        return estadVeh;
    }

    public void setEstadVeh(String estadVeh) {
        this.estadVeh = estadVeh;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getCodVeh()== null || getCodVeh().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}

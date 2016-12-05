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
public class GrabarEmpForm extends org.apache.struts.action.ActionForm {
    private String codEmp, nomEmp, apeEmp, dirEmp, dniEmp, licCon, telEmp, seguroEmp, emailEmp;

    public String getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApeEmp() {
        return apeEmp;
    }

    public void setApeEmp(String apeEmp) {
        this.apeEmp = apeEmp;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    public String getDniEmp() {
        return dniEmp;
    }

    public void setDniEmp(String dniEmp) {
        this.dniEmp = dniEmp;
    }

    public String getLicCon() {
        return licCon;
    }

    public void setLicCon(String licCon) {
        this.licCon = licCon;
    }

    public String getTelEmp() {
        return telEmp;
    }

    public void setTelEmp(String telEmp) {
        this.telEmp = telEmp;
    }

    public String getSeguroEmp() {
        return seguroEmp;
    }

    public void setSeguroEmp(String seguroEmp) {
        this.seguroEmp = seguroEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getCodEmp()== null || getCodEmp().length() < 1 || getNomEmp()== null || getNomEmp().length() < 1
                || getApeEmp()== null || getApeEmp().length() < 1 || getDirEmp()== null || getDirEmp().length() < 1
                || getDniEmp()== null || getDniEmp().length() < 1 || getLicCon()== null || getLicCon().length() < 1
                || getTelEmp()== null || getTelEmp().length() < 1 || getSeguroEmp()== null || getSeguroEmp().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            
        }
        return errors;
    }
}

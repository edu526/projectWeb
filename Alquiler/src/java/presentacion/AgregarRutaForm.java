/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author edd
 */
public class AgregarRutaForm extends org.apache.struts.action.ActionForm {

    private String cod;
    ArrayList dialist = new ArrayList();
    private String dias;
    
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public ArrayList getDialist() {

        ArrayList list = new ArrayList();
        list.add(0, "");
        list.add(1, "Lunes");
        list.add(2, "Martes");
        list.add(3, "Miercoles");
        list.add(4, "Jueves");
        list.add(5, "Viernes");
        list.add(6, "Sábado");
        list.add(7, "Domingo");
        return list;
    }

    public void setDialist(ArrayList dialist) {
        this.dialist = dialist;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getCod() == null || getCod().length() < 1 || getDias()== null || getDias().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}

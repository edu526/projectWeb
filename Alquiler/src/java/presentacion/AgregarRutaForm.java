/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import negocio.AlquilerObj;

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
    private String d[] = {"Domingo", "Sábado", "Viernes", "Jueves", "Miercoles", "Martes", "Lunes", ""};
    List<String> di = AlquilerObj.d;

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
        boolean es = false ;
        if (di.size() == 0) {
            for (int i = 0; i < d.length; i++) {
                list.add(0, d[i]);
            }
        } else {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < di.size(); j++) {
                    if (di.get(j).equalsIgnoreCase(d[i])) {
                        es = true;
                        break;
                    }else{
                        es = false;
                    }
                }
                if (!es) {
                    list.add(0, d[i]);
                }

            }
        }

        return list;
    }

    public void setDialist(ArrayList dialist) {
        this.dialist = dialist;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getCod() == null || getCod().length() < 1 || getDias() == null || getDias().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }

}

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
public class optform extends org.apache.struts.action.ActionForm {

    private String message;
    private String colors;
    ArrayList colorlist = new ArrayList();

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public ArrayList getColorlist() {

        ArrayList list=new ArrayList();
        list.add(0,"Red");
        list.add(1,"Blue");
        list.add(2,"Green");
        return list;
    }

    public void setColorlist(ArrayList colorlist) {
        this.colorlist = colorlist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


 }

package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import persistencia.Alquiler;
import persistencia.Datos;

public class AlquilerObj {

    private LineaObj linObj;
    private String estadAlq;
    private EmpleadoObj codEmp;
    private VehiculoObj codVeh;

    private String numAlq;

    public String getNumAlq() {
        return numAlq;
    }

    public LineaObj getLinObj() {
        return linObj;
    }

    public void setLinObj(RutaObj rutObj) {
        linObj = new LineaObj();
        linObj.setCodRut(rutObj);
        linObj.setNumAlq(getNumAlq());
    }

    public String getHora() {
        Date f = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(f);
    }

    public void setNumAlq(int tAl) {

        this.numAlq = "P" + (tAl + 1);
    }

    public String getFecAlq() {
        Date f = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(f);
    }

    public String getEstadAlq() {
        return estadAlq;
    }

    public void setEstadAlq(String estadAlq) {
        this.estadAlq = estadAlq;
    }

    public double getDesct() {
        return getTotal()*0.05;
    }

    public EmpleadoObj getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(EmpleadoObj codEmp) {
        this.codEmp = codEmp;
    }

    public VehiculoObj getCodVeh() {
        return codVeh;
    }

    public void setCodVeh(VehiculoObj codVeh) {
        this.codVeh = codVeh;
    }

    public double getTotal() {
        return codVeh.getPrecVeh() + linObj.getCodRut().getPrecRut();
    }
    
    public boolean restriccion(List<Alquiler> li){
        for (Alquiler a: li) {
            if (a.getCodemp().getCodemp().equals(getCodEmp().getCodEmp())) {
                return false;
            }
        }
        return true;
    }
}

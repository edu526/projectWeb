package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.Alquiler;

public class AlquilerObj {

    private List cesta = new ArrayList();
    private String estadAlq;
    private EmpleadoObj codEmp;
    private VehiculoObj codVeh;

    private String numAlq;

    public List getCesta() {
        return cesta;
    }

    public String getNumAlq() {
        return numAlq;
    }

    public void agregarLinea(RutaObj rutObj, String dia) {
        LineaObj lin = new LineaObj();
        lin.setCodRut(rutObj);
        lin.setDia(dia);
        lin.setNumAlq(getNumAlq());
        cesta.add(lin);
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
        if (cesta.size()>=4) {
            return (getImporteRutas()+getImporteVehículo()) * 0.10;
        }
        return 0.00;        
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

    public double getImporteRutas() {
        double total = 0;
        for (int i = 0; i < cesta.size(); i++) {
            LineaObj lin = (LineaObj) cesta.get(i);
            total += lin.getCodRut().getPrecRut();
        }
        return total;
    }
    
    public double getImporteVehículo(){
        return getCodVeh().getPrecVeh()*getCesta().size();
    }
    
    public double getTotal() {
        return getImporteRutas()+getImporteVehículo()-getDesct();
    }

    public boolean restriccion(List<Alquiler> li) {
        for (Alquiler a : li) {
            if (a.getCodemp().getCodemp().equals(getCodEmp().getCodEmp())) {
                return false;
            }
        }
        return true;
    }
}

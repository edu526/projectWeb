
package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AquilerObj {
    
    private List cesta = new ArrayList();
    private String numAlq, fecAlq, estadAlq, hora;
    private double tot, desct;
    private EmpleadoObj codEmp;
    private VehiculoObj codVeh;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNumAlq() {
        return numAlq;
    }

    public void setNumAlq(String numAlq) {
        this.numAlq = numAlq;
    }

    public String getFecAlq() {
        return fecAlq;
    }

    public void setFecAlq(String fecAlq) {
        this.fecAlq = fecAlq;
    }

    public String getEstadAlq() {
        return estadAlq;
    }

    public void setEstadAlq(String estadAlq) {
        this.estadAlq = estadAlq;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    public double getDesct() {
        return desct;
    }

    public void setDesct(double desct) {
        this.desct = desct;
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
    
     public List getCesta() {
        return cesta;
    }


    public void setCesta(List cesta) {
        this.cesta = cesta;
    }
       
    public String getGenerarNumero(){
        int num=0;
        Random md=new Random();
        num=(int)(md.nextDouble()*100+0);
        return String.valueOf("P"+num);
    }
    
    public double getCalcularTotal(){
        double total=0;
        for(int i=0;i<cesta.size();i++){
            LineaObj lin =(LineaObj)cesta.get(i);
            total+=lin.getTotal();
        }        
        return total;
    }

     public String getGenerarFec(){
        Date f=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(f);
    }
    
    public String getGenerarHora(){
        Date f=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        return sdf.format(f);
    }
    
    public void agregarLinea(RutaObj rut,int dia){
        LineaObj lin=new LineaObj();
        lin.setRuta(rut);
        lin.setDia(dia);
        cesta.add(lin);
    } 
    
    public void quitarLinea(String cod){
        for(int i=0;i<cesta.size();i++){
            LineaObj lin=(LineaObj)cesta.get(i);
            String numObt=lin.getRuta().getCodRut();
            if(numObt.equals(cod)){
                cesta.remove(i);
            }
        }         
    }
}


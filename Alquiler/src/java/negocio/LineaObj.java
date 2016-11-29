
package negocio;

import java.util.Date;

public class LineaObj {
    
    private String numAlq;
    private RutaObj ruta;
    private int dia;

    public String getNumAlq() {
        return numAlq;
    }

    public void setNumAlq(String numAlq) {
        this.numAlq = numAlq;
    }

    public RutaObj getRuta() {
        return ruta;
    }

    public void setRuta(RutaObj ruta) {
        this.ruta = ruta;
    }

    public double getTotal(){
        return ruta.getPrecRut()*dia;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }
}

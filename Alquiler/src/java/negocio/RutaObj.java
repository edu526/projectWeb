
package negocio;

public class RutaObj {
    
    private String codRut, paradAut;
    private double precRut;

    public RutaObj() {
        this.codRut = " ";
        this.paradAut = " ";
        this.precRut = 0.00;
    }

    
    
    public String getCodRut() {
        return codRut;
    }

    public void setCodRut(String codRut) {
        this.codRut = codRut;
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
    
}

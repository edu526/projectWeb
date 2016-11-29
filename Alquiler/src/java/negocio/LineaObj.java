
package negocio;

import java.util.Date;

public class LineaObj {
    
    private String numAlq, codRut, hora;
    private Date dia;

    public String getNumAlq() {
        return numAlq;
    }

    public void setNumAlq(String numAlq) {
        this.numAlq = numAlq;
    }

    public String getCodRut() {
        return codRut;
    }

    public void setCodRut(String codRut) {
        this.codRut = codRut;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    
}

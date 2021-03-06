/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author edd
 */
@Embeddable
public class LineaAlquilerPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NUMALQ")
    private String numalq;
    @Basic(optional = false)
    @Column(name = "CODRUT")
    private String codrut;
    @Basic(optional = false)
    @Column(name = "DIA")
    private String dia;

    public LineaAlquilerPK() {
    }

    public LineaAlquilerPK(String numalq, String codrut, String dia) {
        this.numalq = numalq;
        this.codrut = codrut;
        this.dia = dia;
    }

    public String getNumalq() {
        return numalq;
    }

    public void setNumalq(String numalq) {
        this.numalq = numalq;
    }

    public String getCodrut() {
        return codrut;
    }

    public void setCodrut(String codrut) {
        this.codrut = codrut;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numalq != null ? numalq.hashCode() : 0);
        hash += (codrut != null ? codrut.hashCode() : 0);
        hash += (dia != null ? dia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaAlquilerPK)) {
            return false;
        }
        LineaAlquilerPK other = (LineaAlquilerPK) object;
        if ((this.numalq == null && other.numalq != null) || (this.numalq != null && !this.numalq.equals(other.numalq))) {
            return false;
        }
        if ((this.codrut == null && other.codrut != null) || (this.codrut != null && !this.codrut.equals(other.codrut))) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.LineaAlquilerPK[ numalq=" + numalq + ", codrut=" + codrut + ", dia=" + dia + " ]";
    }
    
}

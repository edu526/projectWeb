/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edd
 */
@Entity
@Table(name = "LINEA_ALQUILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaAlquiler.findAll", query = "SELECT l FROM LineaAlquiler l")
    , @NamedQuery(name = "LineaAlquiler.findByNumalq", query = "SELECT l FROM LineaAlquiler l WHERE l.lineaAlquilerPK.numalq = :numalq")
    , @NamedQuery(name = "LineaAlquiler.findByCodrut", query = "SELECT l FROM LineaAlquiler l WHERE l.lineaAlquilerPK.codrut = :codrut")
    , @NamedQuery(name = "LineaAlquiler.findByDia", query = "SELECT l FROM LineaAlquiler l WHERE l.lineaAlquilerPK.dia = :dia")})
public class LineaAlquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineaAlquilerPK lineaAlquilerPK;
    @JoinColumn(name = "NUMALQ", referencedColumnName = "NUMALQ", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alquiler alquiler;
    @JoinColumn(name = "CODRUT", referencedColumnName = "CODRUT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ruta ruta;

    public LineaAlquiler() {
    }

    public LineaAlquiler(LineaAlquilerPK lineaAlquilerPK) {
        this.lineaAlquilerPK = lineaAlquilerPK;
    }

    public LineaAlquiler(String numalq, String codrut, String dia) {
        this.lineaAlquilerPK = new LineaAlquilerPK(numalq, codrut, dia);
    }

    public LineaAlquilerPK getLineaAlquilerPK() {
        return lineaAlquilerPK;
    }

    public void setLineaAlquilerPK(LineaAlquilerPK lineaAlquilerPK) {
        this.lineaAlquilerPK = lineaAlquilerPK;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaAlquilerPK != null ? lineaAlquilerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaAlquiler)) {
            return false;
        }
        LineaAlquiler other = (LineaAlquiler) object;
        if ((this.lineaAlquilerPK == null && other.lineaAlquilerPK != null) || (this.lineaAlquilerPK != null && !this.lineaAlquilerPK.equals(other.lineaAlquilerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.LineaAlquiler[ lineaAlquilerPK=" + lineaAlquilerPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edd
 */
@Entity
@Table(name = "RUTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByCodrut", query = "SELECT r FROM Ruta r WHERE r.codrut = :codrut")
    , @NamedQuery(name = "Ruta.findByParadaut", query = "SELECT r FROM Ruta r WHERE r.paradaut = :paradaut")
    , @NamedQuery(name = "Ruta.findByPrecrut", query = "SELECT r FROM Ruta r WHERE r.precrut = :precrut")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRUT")
    private String codrut;
    @Column(name = "PARADAUT")
    private String paradaut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECRUT")
    private Double precrut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    private List<LineaAlquiler> lineaAlquilerList;

    public Ruta() {
    }

    public Ruta(String codrut) {
        this.codrut = codrut;
    }

    public String getCodrut() {
        return codrut;
    }

    public void setCodrut(String codrut) {
        this.codrut = codrut;
    }

    public String getParadaut() {
        return paradaut;
    }

    public void setParadaut(String paradaut) {
        this.paradaut = paradaut;
    }

    public Double getPrecrut() {
        return precrut;
    }

    public void setPrecrut(Double precrut) {
        this.precrut = precrut;
    }

    @XmlTransient
    public List<LineaAlquiler> getLineaAlquilerList() {
        return lineaAlquilerList;
    }

    public void setLineaAlquilerList(List<LineaAlquiler> lineaAlquilerList) {
        this.lineaAlquilerList = lineaAlquilerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrut != null ? codrut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.codrut == null && other.codrut != null) || (this.codrut != null && !this.codrut.equals(other.codrut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Ruta[ codrut=" + codrut + " ]";
    }
    
}

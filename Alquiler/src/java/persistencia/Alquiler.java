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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ALQUILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
    , @NamedQuery(name = "Alquiler.findByNumalq", query = "SELECT a FROM Alquiler a WHERE a.numalq = :numalq")
    , @NamedQuery(name = "Alquiler.findByFecalq", query = "SELECT a FROM Alquiler a WHERE a.fecalq = :fecalq")
    , @NamedQuery(name = "Alquiler.findByEstadalq", query = "SELECT a FROM Alquiler a WHERE a.estadalq = :estadalq")
    , @NamedQuery(name = "Alquiler.findByTot", query = "SELECT a FROM Alquiler a WHERE a.tot = :tot")
    , @NamedQuery(name = "Alquiler.findByDesct", query = "SELECT a FROM Alquiler a WHERE a.desct = :desct")})
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMALQ")
    private String numalq;
    @Column(name = "FECALQ")
    private String fecalq;
    @Column(name = "ESTADALQ")
    private String estadalq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOT")
    private Double tot;
    @Column(name = "DESCT")
    private Double desct;
    @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP")
    @ManyToOne
    private Empleado codemp;
    @JoinColumn(name = "CODVEH", referencedColumnName = "CODVEH")
    @ManyToOne
    private Vehiculo codveh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alquiler")
    private List<LineaAlquiler> lineaAlquilerList;

    public Alquiler() {
    }

    public Alquiler(String numalq) {
        this.numalq = numalq;
    }

    public String getNumalq() {
        return numalq;
    }

    public void setNumalq(String numalq) {
        this.numalq = numalq;
    }

    public String getFecalq() {
        return fecalq;
    }

    public void setFecalq(String fecalq) {
        this.fecalq = fecalq;
    }

    public String getEstadalq() {
        return estadalq;
    }

    public void setEstadalq(String estadalq) {
        this.estadalq = estadalq;
    }

    public Double getTot() {
        return tot;
    }

    public void setTot(Double tot) {
        this.tot = tot;
    }

    public Double getDesct() {
        return desct;
    }

    public void setDesct(Double desct) {
        this.desct = desct;
    }

    public Empleado getCodemp() {
        return codemp;
    }

    public void setCodemp(Empleado codemp) {
        this.codemp = codemp;
    }

    public Vehiculo getCodveh() {
        return codveh;
    }

    public void setCodveh(Vehiculo codveh) {
        this.codveh = codveh;
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
        hash += (numalq != null ? numalq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquiler)) {
            return false;
        }
        Alquiler other = (Alquiler) object;
        if ((this.numalq == null && other.numalq != null) || (this.numalq != null && !this.numalq.equals(other.numalq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Alquiler[ numalq=" + numalq + " ]";
    }
    
}

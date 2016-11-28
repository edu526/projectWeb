/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miriam
 */
@Entity
@Table(name = "ALQUILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a"),
    @NamedQuery(name = "Alquiler.findByNumalq", query = "SELECT a FROM Alquiler a WHERE a.numalq = :numalq"),
    @NamedQuery(name = "Alquiler.findByFecdev", query = "SELECT a FROM Alquiler a WHERE a.fecdev = :fecdev"),
    @NamedQuery(name = "Alquiler.findByFecent", query = "SELECT a FROM Alquiler a WHERE a.fecent = :fecent"),
    @NamedQuery(name = "Alquiler.findByEstadalq", query = "SELECT a FROM Alquiler a WHERE a.estadalq = :estadalq"),
    @NamedQuery(name = "Alquiler.findByMontoalq", query = "SELECT a FROM Alquiler a WHERE a.montoalq = :montoalq")})
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMALQ")
    private String numalq;
    @Basic(optional = false)
    @Column(name = "FECDEV")
    @Temporal(TemporalType.DATE)
    private Date fecdev;
    @Basic(optional = false)
    @Column(name = "FECENT")
    @Temporal(TemporalType.DATE)
    private Date fecent;
    @Basic(optional = false)
    @Column(name = "ESTADALQ")
    private String estadalq;
    @Basic(optional = false)
    @Column(name = "MONTOALQ")
    private double montoalq;
    @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP")
    @ManyToOne(optional = false)
    private Empleado codemp;
    @JoinColumn(name = "CODVEH", referencedColumnName = "CODVEH")
    @ManyToOne(optional = false)
    private Vehiculo codveh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alquiler")
    private List<LineaAlquiler> lineaAlquilerList;

    public Alquiler() {
    }

    public Alquiler(String numalq) {
        this.numalq = numalq;
    }

    public Alquiler(String numalq, Date fecdev, Date fecent, String estadalq, double montoalq) {
        this.numalq = numalq;
        this.fecdev = fecdev;
        this.fecent = fecent;
        this.estadalq = estadalq;
        this.montoalq = montoalq;
    }

    public String getNumalq() {
        return numalq;
    }

    public void setNumalq(String numalq) {
        this.numalq = numalq;
    }

    public Date getFecdev() {
        return fecdev;
    }

    public void setFecdev(Date fecdev) {
        this.fecdev = fecdev;
    }

    public Date getFecent() {
        return fecent;
    }

    public void setFecent(Date fecent) {
        this.fecent = fecent;
    }

    public String getEstadalq() {
        return estadalq;
    }

    public void setEstadalq(String estadalq) {
        this.estadalq = estadalq;
    }

    public double getMontoalq() {
        return montoalq;
    }

    public void setMontoalq(double montoalq) {
        this.montoalq = montoalq;
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

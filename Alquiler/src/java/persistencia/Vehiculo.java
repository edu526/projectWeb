/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByCodveh", query = "SELECT v FROM Vehiculo v WHERE v.codveh = :codveh")
    , @NamedQuery(name = "Vehiculo.findByNflota", query = "SELECT v FROM Vehiculo v WHERE v.nflota = :nflota")
    , @NamedQuery(name = "Vehiculo.findByMatricuveh", query = "SELECT v FROM Vehiculo v WHERE v.matricuveh = :matricuveh")
    , @NamedQuery(name = "Vehiculo.findByModelveh", query = "SELECT v FROM Vehiculo v WHERE v.modelveh = :modelveh")
    , @NamedQuery(name = "Vehiculo.findByMotorveh", query = "SELECT v FROM Vehiculo v WHERE v.motorveh = :motorveh")
    , @NamedQuery(name = "Vehiculo.findBySerieveh", query = "SELECT v FROM Vehiculo v WHERE v.serieveh = :serieveh")
    , @NamedQuery(name = "Vehiculo.findByAnioveh", query = "SELECT v FROM Vehiculo v WHERE v.anioveh = :anioveh")
    , @NamedQuery(name = "Vehiculo.findByEstadveh", query = "SELECT v FROM Vehiculo v WHERE v.estadveh = :estadveh")
    , @NamedQuery(name = "Vehiculo.findByTipoveh", query = "SELECT v FROM Vehiculo v WHERE v.tipoveh = :tipoveh")
    , @NamedQuery(name = "Vehiculo.findByPrecveh", query = "SELECT v FROM Vehiculo v WHERE v.precveh = :precveh")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVEH")
    private String codveh;
    @Column(name = "NFLOTA")
    private String nflota;
    @Column(name = "MATRICUVEH")
    private String matricuveh;
    @Column(name = "MODELVEH")
    private String modelveh;
    @Column(name = "MOTORVEH")
    private String motorveh;
    @Column(name = "SERIEVEH")
    private String serieveh;
    @Column(name = "ANIOVEH")
    private String anioveh;
    @Column(name = "ESTADVEH")
    private String estadveh;
    @Column(name = "TIPOVEH")
    private String tipoveh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECVEH")
    private Double precveh;
    @OneToMany(mappedBy = "codveh")
    private List<Alquiler> alquilerList;
    @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP")
    @ManyToOne
    private Empleado codemp;

    public Vehiculo() {
    }

    public Vehiculo(String codveh) {
        this.codveh = codveh;
    }

    public String getCodveh() {
        return codveh;
    }

    public void setCodveh(String codveh) {
        this.codveh = codveh;
    }

    public String getNflota() {
        return nflota;
    }

    public void setNflota(String nflota) {
        this.nflota = nflota;
    }

    public String getMatricuveh() {
        return matricuveh;
    }

    public void setMatricuveh(String matricuveh) {
        this.matricuveh = matricuveh;
    }

    public String getModelveh() {
        return modelveh;
    }

    public void setModelveh(String modelveh) {
        this.modelveh = modelveh;
    }

    public String getMotorveh() {
        return motorveh;
    }

    public void setMotorveh(String motorveh) {
        this.motorveh = motorveh;
    }

    public String getSerieveh() {
        return serieveh;
    }

    public void setSerieveh(String serieveh) {
        this.serieveh = serieveh;
    }

    public String getAnioveh() {
        return anioveh;
    }

    public void setAnioveh(String anioveh) {
        this.anioveh = anioveh;
    }

    public String getEstadveh() {
        return estadveh;
    }

    public void setEstadveh(String estadveh) {
        this.estadveh = estadveh;
    }

    public String getTipoveh() {
        return tipoveh;
    }

    public void setTipoveh(String tipoveh) {
        this.tipoveh = tipoveh;
    }

    public Double getPrecveh() {
        return precveh;
    }

    public void setPrecveh(Double precveh) {
        this.precveh = precveh;
    }

    @XmlTransient
    public List<Alquiler> getAlquilerList() {
        return alquilerList;
    }

    public void setAlquilerList(List<Alquiler> alquilerList) {
        this.alquilerList = alquilerList;
    }

    public Empleado getCodemp() {
        return codemp;
    }

    public void setCodemp(Empleado codemp) {
        this.codemp = codemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codveh != null ? codveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.codveh == null && other.codveh != null) || (this.codveh != null && !this.codveh.equals(other.codveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Vehiculo[ codveh=" + codveh + " ]";
    }
    
}

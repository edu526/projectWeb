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
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCodemp", query = "SELECT e FROM Empleado e WHERE e.codemp = :codemp")
    , @NamedQuery(name = "Empleado.findByNomemp", query = "SELECT e FROM Empleado e WHERE e.nomemp = :nomemp")
    , @NamedQuery(name = "Empleado.findByApeemp", query = "SELECT e FROM Empleado e WHERE e.apeemp = :apeemp")
    , @NamedQuery(name = "Empleado.findByDiremp", query = "SELECT e FROM Empleado e WHERE e.diremp = :diremp")
    , @NamedQuery(name = "Empleado.findByDniemp", query = "SELECT e FROM Empleado e WHERE e.dniemp = :dniemp")
    , @NamedQuery(name = "Empleado.findByLiccon", query = "SELECT e FROM Empleado e WHERE e.liccon = :liccon")
    , @NamedQuery(name = "Empleado.findByTelemp", query = "SELECT e FROM Empleado e WHERE e.telemp = :telemp")
    , @NamedQuery(name = "Empleado.findBySeguroemp", query = "SELECT e FROM Empleado e WHERE e.seguroemp = :seguroemp")
    , @NamedQuery(name = "Empleado.findByEmailemp", query = "SELECT e FROM Empleado e WHERE e.emailemp = :emailemp")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMP")
    private String codemp;
    @Column(name = "NOMEMP")
    private String nomemp;
    @Column(name = "APEEMP")
    private String apeemp;
    @Column(name = "DIREMP")
    private String diremp;
    @Column(name = "DNIEMP")
    private String dniemp;
    @Column(name = "LICCON")
    private String liccon;
    @Column(name = "TELEMP")
    private String telemp;
    @Column(name = "SEGUROEMP")
    private String seguroemp;
    @Column(name = "EMAILEMP")
    private String emailemp;
    @OneToMany(mappedBy = "codemp")
    private List<Alquiler> alquilerList;
    @OneToMany(mappedBy = "codemp")
    private List<Vehiculo> vehiculoList;

    public Empleado() {
    }

    public Empleado(String codemp) {
        this.codemp = codemp;
    }

    public String getCodemp() {
        return codemp;
    }

    public void setCodemp(String codemp) {
        this.codemp = codemp;
    }

    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }

    public String getApeemp() {
        return apeemp;
    }

    public void setApeemp(String apeemp) {
        this.apeemp = apeemp;
    }

    public String getDiremp() {
        return diremp;
    }

    public void setDiremp(String diremp) {
        this.diremp = diremp;
    }

    public String getDniemp() {
        return dniemp;
    }

    public void setDniemp(String dniemp) {
        this.dniemp = dniemp;
    }

    public String getLiccon() {
        return liccon;
    }

    public void setLiccon(String liccon) {
        this.liccon = liccon;
    }

    public String getTelemp() {
        return telemp;
    }

    public void setTelemp(String telemp) {
        this.telemp = telemp;
    }

    public String getSeguroemp() {
        return seguroemp;
    }

    public void setSeguroemp(String seguroemp) {
        this.seguroemp = seguroemp;
    }

    public String getEmailemp() {
        return emailemp;
    }

    public void setEmailemp(String emailemp) {
        this.emailemp = emailemp;
    }

    @XmlTransient
    public List<Alquiler> getAlquilerList() {
        return alquilerList;
    }

    public void setAlquilerList(List<Alquiler> alquilerList) {
        this.alquilerList = alquilerList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codemp != null ? codemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codemp == null && other.codemp != null) || (this.codemp != null && !this.codemp.equals(other.codemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Empleado[ codemp=" + codemp + " ]";
    }
    
}

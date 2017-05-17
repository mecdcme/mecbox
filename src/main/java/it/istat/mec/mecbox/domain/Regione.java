/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author papizzo
 */
@Entity
@Table(name = "mb_regioni")
public class Regione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_reg")
    private Integer codReg;
    @Size(max = 255)
    @Column(name = "regione")
    private String regione;
    @Size(max = 255)
    @Column(name = "regione_2")
    private String regione2;
    /*@OneToMany(mappedBy = "codReg" ,fetch= FetchType.LAZY)*/    
    @OneToMany(mappedBy = "codReg")
    @JsonBackReference
    private Collection<Comune> comuneCollection;
    /*@OneToMany(mappedBy = "codReg", fetch= FetchType.LAZY)**/
    @OneToMany(mappedBy = "codReg")
    @JsonBackReference
    private Collection<Provincia> provinciaCollection;

    public Regione() {
    
    }

    public Regione(Integer codReg) {
        this.codReg = codReg;
    }

    public Integer getCodReg() {
        return codReg;
    }

    public void setCodReg(Integer codReg) {
        this.codReg = codReg;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getRegione2() {
        return regione2;
    }

    public void setRegione2(String regione2) {
        this.regione2 = regione2;
    }

    @XmlTransient
    public Collection<Comune> getComuneCollection() {
        return comuneCollection;
    }

    public void setComuneCollection(Collection<Comune> comuneCollection) {
        this.comuneCollection = comuneCollection;
    }

    @XmlTransient
    public Collection<Provincia> getProvinciaCollection() {
        return provinciaCollection;
    }

    public void setProvinciaCollection(Collection<Provincia> provinciaCollection) {
        this.provinciaCollection = provinciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReg != null ? codReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regione)) {
            return false;
        }
        Regione other = (Regione) object;
        if ((this.codReg == null && other.codReg != null) || (this.codReg != null && !this.codReg.equals(other.codReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.istat.mec.mecbox.domain.Regione[ codReg=" + codReg + " ]";
    }
    
}

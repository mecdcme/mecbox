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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Table(name = "mb_province")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pro")
    private Integer codPro;
    
    @Size(max = 255)
    @Column(name = "provincia")
    private String provincia;
    
    @Size(max = 255)
    @Column(name = "provincia_2")
    private String provincia2;
    
    @OneToMany(mappedBy = "codPro")
    @JsonBackReference
    private Collection<Comune> comuneCollection;
    
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne
    @JsonBackReference
    private Regione codReg;

    public Provincia() {
    }

    public Provincia(Integer codPro) {
        this.codPro = codPro;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia2() {
        return provincia2;
    }

    public void setProvincia2(String provincia2) {
        this.provincia2 = provincia2;
    }

    @XmlTransient
    public Collection<Comune> getComuneCollection() {
        return comuneCollection;
    }

    public void setComuneCollection(Collection<Comune> comuneCollection) {
        this.comuneCollection = comuneCollection;
    }

    public Regione getCodReg() {
        return codReg;
    }

    public void setCodReg(Regione codReg) {
        this.codReg = codReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.istat.mec.mecbox.domain.Provincia[ codPro=" + codPro + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author papizzo
 */

@Entity
@Table(name = "mb_comuni")
public class Comune implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_com")
    private Integer codCom;
    @Size(max = 255)
    @Column(name = "comune")
    private String comune;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne
    @JsonBackReference
    private Regione codReg;
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")
    @ManyToOne
    @JsonBackReference
    private Provincia codPro;

    public Comune() {
    }

    public Comune(Integer codCom) {
        this.codCom = codCom;
    }

    public Integer getCodCom() {
        return codCom;
    }

    public void setCodCom(Integer codCom) {
        this.codCom = codCom;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public Regione getCodReg() {
        return codReg;
    }

    public void setCodReg(Regione codReg) {
        this.codReg = codReg;
    }

    public Provincia getCodPro() {
        return codPro;
    }

    public void setCodPro(Provincia codPro) {
        this.codPro = codPro;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCom != null ? codCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comune)) {
            return false;
        }
        Comune other = (Comune) object;
        if ((this.codCom == null && other.codCom != null) || (this.codCom != null && !this.codCom.equals(other.codCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.istat.mec.mecbox.domain.Comune[ codCom=" + codCom + " ]";
    }
    
}

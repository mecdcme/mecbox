/**
 *
 * @author papizzo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "r_religion")

public class Religion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "religion")
    private String religion;

    @Column(name = "individuals")
    private String individuals;

    public Religion() {

    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getIndividuals() {
        return individuals;
    }

    public void setIndividuals(String individuals) {
        this.individuals = individuals;
    }

}

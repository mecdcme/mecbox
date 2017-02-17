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

/**
 *
 * @author papizzo
 */

@Entity
@Table(name = "mr_sex_by_age_group")

public class SexDistribution implements Serializable{

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column(name = "id")
    private String id;    

    @Column(name = "range")
    private String range;

    @Column(name = "male")
    private String male;

    @Column(name = "female")
    private String female;



    public SexDistribution() {
        
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }
    

    
}
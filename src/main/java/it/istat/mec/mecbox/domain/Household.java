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
@Table(name = "r_household_by_ea")

public class Household implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "region")
    private String region;

    @Column(name = "zone")
    private Integer zone;

    @Column(name = "woreda")
    private Integer woreda;

    @Column(name = "city")
    private Integer city;

    @Column(name = "subcity")
    private Integer subcity;

    @Column(name = "psa")
    private Integer psa;

    @Column(name = "sa")
    private Integer sa;

    @Column(name = "kebele")
    private Integer kebele;

    @Column(name = "ea")
    private Integer ea;

    @Id
    @Column(name = "household")
    private Long household;

    public Household() {

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public Integer getWoreda() {
        return woreda;
    }

    public void setWoreda(Integer woreda) {
        this.woreda = woreda;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getSubcity() {
        return subcity;
    }

    public void setSubcity(Integer subcity) {
        this.subcity = subcity;
    }

    public Integer getPsa() {
        return psa;
    }

    public void setPsa(Integer psa) {
        this.psa = psa;
    }

    public Integer getSa() {
        return sa;
    }

    public void setSa(Integer sa) {
        this.sa = sa;
    }

    public Integer getKebele() {
        return kebele;
    }

    public void setKebele(Integer kebele) {
        this.kebele = kebele;
    }

    public Integer getEa() {
        return ea;
    }

    public void setEa(Integer ea) {
        this.ea = ea;
    }

    public Long getHousehold() {
        return household;
    }

    public void setHousehold(Long household) {
        this.household = household;
    }

}

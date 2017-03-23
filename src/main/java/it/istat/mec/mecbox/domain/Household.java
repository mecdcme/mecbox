package it.istat.mec.mecbox.domain;

/**
 * Copyright 2017 ISTAT
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence. You may
 * obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations under
 * the Licence.
 *
 * @author Francesco Amato <framato @ istat.it>
 * @author Mauro Bruno <mbruno @ istat.it>
 * @author Stefano Macone <stefano.macone @ istat.it>
 * @author Andrea Pagano <andrea.pagano @ istat.it>
 * @author Paolo Pizzo <papizzo @ istat.it>
 * @version 1.0
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mb_household")
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

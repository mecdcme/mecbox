package it.istat.mec.mecbox.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Istat MecBox Team
 */
@Entity
@Table(name = "land")
public class Land implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "N_ISTAT")
    private String cod_istat;

    @Column(name = "PROVINCIA")
    private String provincia;
    
    @Column(name = "REGIONE")
    private String regione;
    
    @Column(name = "COMUNE_MIN")
    private String comune;

    public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public Land() {

    }

    public String getCod_istat() {
		return cod_istat;
	}

	public void setCod_istat(String cod_istat) {
		this.cod_istat = cod_istat;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}




}

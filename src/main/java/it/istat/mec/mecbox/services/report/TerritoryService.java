/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.dao.RegioneDao;
import it.istat.mec.mecbox.dao.ProvinciaDao;
import it.istat.mec.mecbox.domain.Comune;
import it.istat.mec.mecbox.domain.Provincia;
import it.istat.mec.mecbox.domain.Regione;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.istat.mec.mecbox.dao.ComuneDao;

/**
 *
 * @author papizzo
 */
@Service
public class TerritoryService {

    @Autowired
    private RegioneDao regioneDao;

    @Autowired
    private ProvinciaDao provinciaDao;

    @Autowired
    private ComuneDao comuneDao;

    /* Regione */
    public List<Regione> regioneFindAll() {
        return (List<Regione>) regioneDao.findAll();
    }

    public Regione findByCodReg(int codReg) {
        return (Regione) regioneDao.findByCodReg(codReg);
    }

    public Regione findByRegione(String regione) {
        return regioneDao.findByRegione(regione);
    }

    /* Provincia */
    public List<Provincia> provinciaFindAll() {
        return (List<Provincia>) provinciaDao.findAll();
    }

    public List<Provincia> findProvinciaByCodReg(Integer codReg) {
        Regione codiceRegione = new Regione();
        codiceRegione.setCodReg(codReg);
        return (List<Provincia>) provinciaDao.findByCodReg(codiceRegione);
    }

    /* Comune */
    public List<Comune> comuneFindAll() {
        return (List<Comune>) comuneDao.findAll();
    }

    public List<Comune> findComumeByCodRegAndCodPro(Integer codReg, Integer codPro) {

        Regione codiceRegione = new Regione();
        codiceRegione.setCodReg(codReg);

        Provincia codiceProvincia = new Provincia();
        codiceProvincia.setCodPro(codPro);
        
        return (List<Comune>) comuneDao.findByCodRegAndCodPro(codiceRegione, codiceProvincia);

    }

}

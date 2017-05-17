/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Provincia;
import it.istat.mec.mecbox.domain.Regione;
import it.istat.mec.mecbox.domain.Comune;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author papizzo
 */
@Repository
public interface ComuneDao extends CrudRepository <Comune, Integer> {
    
    public List<Comune> findByCodRegAndCodPro(Regione codReg, Provincia codPro);
    
}

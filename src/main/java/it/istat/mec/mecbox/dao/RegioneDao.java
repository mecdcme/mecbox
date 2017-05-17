/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Regione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegioneDao extends CrudRepository<Regione, Integer> {

    public Regione findByCodReg(int codReg);
    public Regione findByRegione(String regione);
    
}

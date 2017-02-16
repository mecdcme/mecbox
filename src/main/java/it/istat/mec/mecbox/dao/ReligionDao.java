/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Religion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author papizzo
 */
@Repository
public interface ReligionDao extends CrudRepository<Religion, Long> {

}

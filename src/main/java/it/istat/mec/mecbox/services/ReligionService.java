/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.services;
import it.istat.mec.mecbox.dao.ReligionDao;
import it.istat.mec.mecbox.domain.Religion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author papizzo
 */


@Service
public class ReligionService {
    
    	@Autowired
	private  ReligionDao religionDao;
	 
	public List<Religion> findAll() {
		// TODO Auto-generated method stub
		return (List<Religion>) this.religionDao.findAll();
	}
    
    
}

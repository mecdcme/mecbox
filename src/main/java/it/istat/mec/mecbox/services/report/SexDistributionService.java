/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.services.report;
import it.istat.mec.mecbox.dao.SexDistributionDao;
import it.istat.mec.mecbox.domain.SexDistribution;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author papizzo
 */

@Service
public class SexDistributionService {
   
    
    @Autowired
    private SexDistributionDao sexdistributionDao;

    public List<SexDistribution> findAll() {
        // TODO Auto-generated method stub
        return (List<SexDistribution>) this.sexdistributionDao.findAll();
    }
}

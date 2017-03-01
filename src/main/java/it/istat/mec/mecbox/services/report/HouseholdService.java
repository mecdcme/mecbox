/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.domain.Household;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.istat.mec.mecbox.dao.HouseholdDao;

/**
 *
 * @author papizzo
 */
@Service
public class HouseholdService {

    @Autowired
    private HouseholdDao householdDao;

    public List<Household> findAll() {
        // TODO Auto-generated method stub
        return (List<Household>) this.householdDao.findAll();
    }

}

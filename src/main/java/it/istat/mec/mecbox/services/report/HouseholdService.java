package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.domain.Household;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.istat.mec.mecbox.dao.HouseholdDao;

/**
 *
 * @author Istat MecBox Team
 */
@Service
public class HouseholdService {

    @Autowired
    private HouseholdDao householdDao;

    public List<Household> findAll() {
        return (List<Household>) this.householdDao.findAll();
    }

}

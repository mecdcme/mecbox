package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.dao.SexDistributionDao;
import it.istat.mec.mecbox.domain.SexDistribution;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Istat MecBox Team
 */
@Service
public class SexDistributionService {

    @Autowired
    private SexDistributionDao sexdistributionDao;

    public List<SexDistribution> findAll() {
        return (List<SexDistribution>) this.sexdistributionDao.findAll();
    }
}

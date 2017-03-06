package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.dao.ReligionDao;
import it.istat.mec.mecbox.domain.Religion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Istat MecBox Team
 */
@Service
public class ReligionService {

    @Autowired
    private ReligionDao religionDao;

    public List<Religion> findAll() {
        return (List<Religion>) this.religionDao.findAll();
    }

}

package it.istat.mec.mecbox.services.report;

import it.istat.mec.mecbox.dao.LandDao;
import it.istat.mec.mecbox.domain.Land;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Istat MecBox Team
 */
@Service
public class LandService {

    @Autowired
    private LandDao landDao;

    public List<Land> findAll() {
        return (List<Land>) landDao.findAll();
    }
    
    public List<Land> findByReg(String reg) {
        return (List<Land>) landDao.findLandbyReg(reg);
    }
    
   
    public List<Land> findByProv(String prov) {
        return  (List<Land>) landDao.findLandbyProv(prov);
    }
}

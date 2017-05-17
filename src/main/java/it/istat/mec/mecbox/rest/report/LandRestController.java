package it.istat.mec.mecbox.rest.report;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.mecbox.domain.Land;
import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.services.report.LandService;

/**
 *
 * @author Istat MecBox Team
 */
@RestController
public class LandRestController {

    @Autowired
    private LandService LandService;

    @GetMapping(value = "/land/restlist")
    public List<Land> religionlist(Model model) {

        List<Land> land = LandService.findAll();
        return land;
    }
    @GetMapping("/prov/{provincia}")
    public List<Land> getLandByProvincia(@PathVariable String provincia) {

    	List<Land> land =  LandService.findByProv(provincia);
        return land;
    }
    @GetMapping("/reg/{regione}")
    public List<Land> getLandByRegione(@PathVariable String regione) {

    	List<Land> land =  LandService.findByReg(regione);
        return land;
    }
}

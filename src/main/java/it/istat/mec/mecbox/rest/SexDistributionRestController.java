package it.istat.mec.mecbox.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.mecbox.domain.SexDistribution;
import it.istat.mec.mecbox.services.SexDistributionService;

@RestController
public class SexDistributionRestController {

    @Autowired
    private SexDistributionService sexdistributionService;

    @RequestMapping(value = "/sexdistribution/restlist")
    public List<SexDistribution>  sexdistributionlist(Model model) {
        // contents as before

        List<SexDistribution> sexdistribution = sexdistributionService.findAll();

        return sexdistribution;
    }

}

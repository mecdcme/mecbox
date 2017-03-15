package it.istat.mec.mecbox.rest.report;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.mecbox.domain.Religion;
import it.istat.mec.mecbox.services.report.ReligionService;

/**
 *
 * @author Istat MecBox Team
 */
@RestController
public class ReligionRestController {

    @Autowired
    private ReligionService religionService;

    @GetMapping(value = "/religionrest")
    public List<Religion> religionlist(Model model) {

        List<Religion> religion = religionService.findAll();
        return religion;
    }

}

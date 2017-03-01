package it.istat.mec.mecbox.rest.report;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.mecbox.domain.Religion;
import it.istat.mec.mecbox.services.report.ReligionService;

@RestController
public class ReligionRestController {

    @Autowired
    private ReligionService religionService;

    @RequestMapping(value = "/religion/restlist")
    public List<Religion> religionlist(Model model) {
        // contents as before

        List<Religion> religion = religionService.findAll();

        return religion;
    }

}

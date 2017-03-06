package it.istat.mec.mecbox.controller.report;

import it.istat.mec.mecbox.domain.Religion;
import it.istat.mec.mecbox.services.report.ReligionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Istat MecBox Team
 */
@Controller
public class ReligionController {

    @Autowired
    private ReligionService religionService;

    @RequestMapping(value = "/religion/religionlist")
    public String religionList(Model model) {

        List<Religion> religionList = religionService.findAll();
        model.addAttribute("religionList", religionList);

        return "religion/religionlist";
    }

}

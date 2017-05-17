package it.istat.mec.mecbox.controller.report;

import it.istat.mec.mecbox.domain.Land;
import it.istat.mec.mecbox.services.report.LandService;
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
public class LandController {

    @Autowired
    private LandService LandService;

    @RequestMapping(value = "/land/landlist")
    public String religionList(Model model) {

        List<Land> LandList = LandService.findAll();
        model.addAttribute("LandList", LandList);

        return "land/landlist";
    }
    
    

}

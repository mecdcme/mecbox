package it.istat.mec.mecbox.controller.report;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Istat MecBox Team
 */
@Controller
public class SexDistributionController {

    @RequestMapping(value = "/sexdistribution/sexdistributionlist")
    public String sexdistributioList(Model model) {

        return "/sexdistribution/sexdistributionlist";
    }

}

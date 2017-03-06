package it.istat.mec.mecbox.controller.report;

import it.istat.mec.mecbox.domain.Household;
import it.istat.mec.mecbox.services.report.HouseholdService;
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
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @RequestMapping(value = "/household/householdlist")
    public String householdList(Model model) {

        List<Household> householdList = householdService.findAll();
        model.addAttribute("householdList", householdList);

        return "household/householdlist";
    }

}

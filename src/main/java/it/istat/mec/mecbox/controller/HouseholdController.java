/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.controller;

import it.istat.mec.mecbox.domain.Household;
import it.istat.mec.mecbox.services.NotificationService;
import it.istat.mec.mecbox.services.HouseholdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author papizzo
 */
@Controller
public class HouseholdController {

  
    @Autowired
    private HouseholdService householdService;

    @RequestMapping(value = "/household/householdlist")
    public String householdList(Model model) {
        // contents as before

        List<Household> householdList = householdService.findAll();
        model.addAttribute("householdList", householdList);

        return "household/householdlist";
    }

}

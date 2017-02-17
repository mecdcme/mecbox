/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.controller;

import it.istat.mec.mecbox.domain.SexDistribution;
import it.istat.mec.mecbox.services.NotificationService;
import it.istat.mec.mecbox.services.SexDistributionService;
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
public class SexDistributionController {
    @Autowired
    private NotificationService notificationService;  
    
     @Autowired
    private SexDistributionService sexdistributionService;
    
    @RequestMapping(value = "/sexdistribution/sexdistributionlist")
    public String sexdistributioList(Model model) {
        // contents as before

        List<SexDistribution> sexdistributionList = sexdistributionService.findAll();
        model.addAttribute("sexdistributionList", sexdistributionList);

        return "/sexdistribution/sexdistributionlist";
    }
    
    
    
}

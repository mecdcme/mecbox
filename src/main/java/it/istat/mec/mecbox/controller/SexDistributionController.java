/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author papizzo
 */
@Controller
public class SexDistributionController {

    
    @RequestMapping(value = "/sexdistribution/sexdistributionlist")
    public String sexdistributioList(Model model) {
        // contents as before  

        return "/sexdistribution/sexdistributionlist";
    }
    
    
    
}

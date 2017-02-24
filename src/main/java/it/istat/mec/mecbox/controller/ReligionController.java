/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.mec.mecbox.controller;

import it.istat.mec.mecbox.domain.Religion;
import it.istat.mec.mecbox.services.ReligionService;
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
public class ReligionController {

       @Autowired
    private ReligionService religionService;

    @RequestMapping(value = "/religion/religionlist")
    public String religionList(Model model) {
        // contents as before

        List<Religion> religionList = religionService.findAll();
        model.addAttribute("religionList", religionList);

        return "religion/religionlist";
    }

}

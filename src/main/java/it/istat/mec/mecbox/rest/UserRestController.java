package it.istat.mec.mecbox.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.istat.mec.mecbox.domain.User;

import it.istat.mec.mecbox.services.UserService;

@RestController
public class UserRestController {

 
    
    @Autowired
    private UserService userService;
    
    
	 @RequestMapping(value = "/users/restgetUser")
   public   User getUser(@RequestParam("id")Long id) {
	       // contents as before
	   
		   User user = userService.findOne(id) ;
		
	   	 return user;
	   }
	 
	 
	 
}

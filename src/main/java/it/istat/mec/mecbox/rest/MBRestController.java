package it.istat.mec.mecbox.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import it.istat.mec.mecbox.domain.User;

import it.istat.mec.mecbox.services.UserService;


@RestController
public class MBRestController {
    
    @Autowired
    private UserService userService;
    
    
	 @RequestMapping(value = "/users/restlist")
   public   List<User> userslist( Model model) {
	       // contents as before
	   
		   List<User> users = userService.findAll();
		
	   	 return users;
	   }
	 
	 
	 
	
	 
	 
	 
}

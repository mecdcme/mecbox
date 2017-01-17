package it.istat.mec.mecbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.istat.mec.mecbox.bean.Role;
import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.forms.LoginForm;
import it.istat.mec.mecbox.forms.UserCreateForm;
import it.istat.mec.mecbox.services.CustomUserDetailsService;
import it.istat.mec.mecbox.services.NotificationService;
import it.istat.mec.mecbox.services.UserService;
import javassist.bytecode.stackmap.BasicBlock.Catch;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping("/users/login")
	public String showLoginForm( LoginForm loginForm) {
		return "users/login";
	}
	/*
	 * @RequestMapping(value = "/users/login", method = RequestMethod.POST)
	 * public String showLoginForm(
	 * 
	 * @Valid LoginForm loginForm, BindingResult bindingResult) {
	 * 
	 * if (bindingResult.hasErrors()) { notificationService.addErrorMessage(
	 * "Si è verificato un errore!"); return "users/login"; }
	 * 
	 * if (! loginService.authentice(loginForm.getUsername(),
	 * loginForm.getPassword())) {
	 * notificationService.addErrorMessage("Invalid login"); return
	 * "users/login"; }
	 * 
	 * httpSession.setAttribute("user",loginForm.getUsername());
	 * 
	 * // Login successful notificationService.addInfoMessage("Benvenuto!");
	 * return "redirect:/"; }
	 */

	@RequestMapping(value = "/users/logout")
	public String logout() {

		// Login successful
		notificationService.addInfoMessage("Arrivederci!");
		return "redirect:/";
	}

	 
	@RequestMapping(value = "/users/newuser", method = RequestMethod.GET)
	public String getUserCreatePage(Model model,@ModelAttribute("userCreateForm") UserCreateForm form) {
		// contents as before
		 
		Role[] allRoles = Role.values();
		model.addAttribute("allRoles", allRoles);
		return "users/newuser";
	}

	@RequestMapping(value = "/users/newuser", method = RequestMethod.POST)
	public String handleUserCreateForm(Model model,@Valid @ModelAttribute("userCreateForm") UserCreateForm form,
			BindingResult bindingResult) {
		// contents as before

		Role[] allRoles = Role.values();
		model.addAttribute("allRoles", allRoles);
		
		if (bindingResult.hasErrors()) {
			return "users/newuser";
		}

		try {
			userService.create(form);
	//		customUserDetailsService.authenticate(form.getEmail(), form.getPassword());
			notificationService.addInfoMessage("Utente creato");
			
		} catch (Exception e) {
			notificationService.addErrorMessage("Errore: " + e.getMessage());
			return "users/newuser";
		}

		return "users/newuser";
	}


	@RequestMapping(value = "/users/userlist")
	public String userslist(Model model) {
		// contents as before

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		return "users/userlist";
	}

}

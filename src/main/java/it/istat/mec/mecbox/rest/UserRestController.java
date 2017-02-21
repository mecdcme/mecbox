
package it.istat.mec.mecbox.rest;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.forms.UserCreateForm;
import it.istat.mec.mecbox.services.NotificationService;
import it.istat.mec.mecbox.services.UserService;
import it.istat.mec.mecbox.services.NotificationService.NotificationMessage;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "/users/restlist")
	public List<User> userslist(Model model) {
		// contents as before

		List<User> users = userService.findAll();

		return users;
	}

	@RequestMapping(value = "/users/restgetUser")
	public User getUser(@RequestParam("id") Long id) {
		// contents as before
		User user = userService.findOne(id);
		return user;
	}

	@RequestMapping(value = "/users/restNewUser", method = RequestMethod.POST)
	public List<NotificationMessage> newUser(@Valid @ModelAttribute("userCreateForm") UserCreateForm form,
			BindingResult bindingResult) {
		// contents as before
		notificationService.removeAllMessages();
		if (!bindingResult.hasErrors()) {

			try {
				userService.create(form);
				// customUserDetailsService.authenticate(form.getEmail(),
				// form.getPassword());
				notificationService.addInfoMessage("User created");

			} catch (Exception e) {
				notificationService.addErrorMessage("Error: " + e.getMessage());

			}
		} else {

			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				notificationService.addErrorMessage(error.getField() + " - " + error.getDefaultMessage());
			}
		}

		return notificationService.getNotificationMessages();
	}

	@RequestMapping(value = "/users/restUpdateUser", method = RequestMethod.POST)
	public List<NotificationMessage> updateUser(@Valid @ModelAttribute("userCreateForm") UserCreateForm form,
			BindingResult bindingResult) {
		// contents as before
		notificationService.removeAllMessages();
		if (!bindingResult.hasErrors()) {

			try {
				userService.update(form);
				// customUserDetailsService.authenticate(form.getEmail(),
				// form.getPassword());
				notificationService.addInfoMessage("User updated");

			} catch (Exception e) {
				notificationService.addErrorMessage("Error: " + e.getMessage());

			}
		} else {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				notificationService.addErrorMessage(error.getField() + " - " + error.getDefaultMessage());
			}

		}

		return notificationService.getNotificationMessages();
	}

	@RequestMapping(value = "/users/restDeleteUser", method = RequestMethod.POST)
	public List<NotificationMessage> deleteUSer(@RequestParam("id") Long id) {
		// contents as before
		notificationService.removeAllMessages();

		try {
			userService.delete(id);
			// customUserDetailsService.authenticate(form.getEmail(),
			// form.getPassword());
			notificationService.addInfoMessage("User deleted");

		} catch (Exception e) {
			notificationService.addErrorMessage("Error" + e.getMessage());

		}

		return notificationService.getNotificationMessages();
	}

	@RequestMapping(value = "/users/updateMyPassword", method = RequestMethod.POST)
	public List<NotificationMessage> updateMyPassword(@RequestParam("passw") String password, Principal principal) {

		String email = principal.getName(); // get logged in username
		// contents as before
		notificationService.removeAllMessages();

		try {
			userService.updatePasswordByEmail(email, password);
			notificationService.addInfoMessage("User updated");

		} catch (Exception e) {
			notificationService.addErrorMessage("Error: " + e.getMessage());

		}

		return notificationService.getNotificationMessages();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/users/updatePassword", method = RequestMethod.POST)
	public List<NotificationMessage> updatePassword(@RequestParam("passw") String password, @RequestParam("id") String id) {

		 
		// contents as before
		notificationService.removeAllMessages();

		try {
			userService.updatePasswordById(Long.parseLong(id), password);
			notificationService.addInfoMessage("Password updated");

		} catch (Exception e) {
			notificationService.addErrorMessage("Error: " + e.getMessage());

		}

		return notificationService.getNotificationMessages();
	}
	
}

package it.istat.mec.mecbox.rest;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.forms.UserCreateForm;
import it.istat.mec.mecbox.services.NotificationService;
import it.istat.mec.mecbox.services.UserService;
import it.istat.mec.mecbox.services.NotificationService.NotificationMessage;

/**
 *
 * @author Istat MecBox Team
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/users")
    public List<User> userslist(Model model) {

        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {

        User user = userService.findOne(id);
        return user;
    }

    @PostMapping("/users")
    public List<NotificationMessage> newUser(@Valid @ModelAttribute("userCreateForm") UserCreateForm form,
            BindingResult bindingResult) {

        notificationService.removeAllMessages();
        if (!bindingResult.hasErrors()) {
            try {
                userService.create(form);
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

    @PutMapping("/users")
    public List<NotificationMessage> updateUser(@Valid @ModelAttribute("userCreateForm") UserCreateForm form,
            BindingResult bindingResult) {

        notificationService.removeAllMessages();
        if (!bindingResult.hasErrors()) {

            try {
                userService.update(form);
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

    @DeleteMapping("/users/{id}")
    public List<NotificationMessage> deleteUser(@PathVariable Long id) {

        notificationService.removeAllMessages();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (id.compareTo(user.getUserid()) == 0) {
            notificationService.addErrorMessage("Error: User can not be deleted !");
        } else {
            try {
                userService.delete(id);
                notificationService.addInfoMessage("User deleted");

            } catch (Exception e) {
                notificationService.addErrorMessage("Error: " + e.getMessage());
            }
        }
        return notificationService.getNotificationMessages();
    }

    @PostMapping(value = "/users/reset_password" )
    public List<NotificationMessage> updateMyPassword(@RequestParam("passw") String password, Principal principal) {

        String email = principal.getName(); // get logged in username
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
    @PostMapping(value = "/users/reset_password/{id}" )
    public List<NotificationMessage> updatePassword(@RequestParam("passw") String password, @PathVariable String id) {

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

package JavaProject.Contacts.controller;

import org.ietf.jgss.Oid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.engine.AttributeName;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import JavaProject.Contacts.ContactsApplication;
import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.helper.Helper;
import JavaProject.Contacts.service.userService;

@Controller
@RequestMapping("/user")
public class UserController {

    //private final Contacts.ContactsApplication contactsApplication;

    private Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    private userService userService;
    

//    UserController(Contacts.ContactsApplication contactsApplication) {
//        this.contactsApplication = contactsApplication;
//    }

    @RequestMapping(value ="/dashboard")
    public String userDashboard() {
        logger.info("User dashboard opened");
        return "user/dashboard";
    }

    @GetMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {

        String username = authentication.getName();

        userApp user = userService.getUserByEmail(username);

        model.addAttribute("loggedInUser", user);

        return "user/profile";
    }
}
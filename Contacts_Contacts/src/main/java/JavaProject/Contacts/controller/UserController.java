package JavaProject.Contacts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import JavaProject.Contacts.service.userService;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    private userService userService;

    @RequestMapping("/dashboard")
    public String userDashboard() {
        logger.info("User dashboard opened");
        return "user/dashboard";
    }

    @RequestMapping("/profile")
    public String userProfile(Model model, Authentication authentication) {
        logger.info("User profile opened");
        return "user/profile";
    }
}
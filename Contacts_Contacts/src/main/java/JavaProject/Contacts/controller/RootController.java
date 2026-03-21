package JavaProject.Contacts.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.helper.Helper;
import JavaProject.Contacts.service.userService;

@ControllerAdvice
public class RootController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private userService userService;
	
	
	@ModelAttribute
    public void addLoggedInUserInformation(Model model , Authentication authentication) {
    	
		 if (authentication == null || !authentication.isAuthenticated()) {
		        return;
		    }

		    String email = authentication.getName();
		
    	System.out.println("Adding logged in user information to the model");

    	String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User Logged In : {}" , username);
        userApp user = userService.getUserByEmail(username);
        
        System.out.println("username");
        	
        	System.out.println(user.getName());
            System.out.println(user.getEmail());
            model.addAttribute("LoggedInUser" , user);
        	
        
    }

}

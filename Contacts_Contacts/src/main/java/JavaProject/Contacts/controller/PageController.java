package JavaProject.Contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.engine.AttributeName;

import org.springframework.ui.Model;

@Controller
public class PageController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		System.out.println("home done");
		model.addAttribute("name", "Contact Manager");
        
		return "home";
	}

}

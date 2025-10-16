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
	
	//about 
	
	@RequestMapping("/about")
	public String aboutpage() {
		System.out.println("about page");
		return "about";
	}
	
	//services
	
	@RequestMapping("/services")
	public String Servicespage() {
		System.out.println("services page");
		return "services";
	}
	
	//contact page
	
	@RequestMapping("/contact")
	public String contactpage() {
		System.out.println("contact page");
		return "contactus";
	}
	
	//login page
	
	@RequestMapping("/login")
	public String loginpage() {
		System.out.println("login page");
		return "login";
	}
	
	//register page
	
	@RequestMapping("/signup")
	public String registerpage() {
		System.out.println("signup page");
		return "signup";
	}

}

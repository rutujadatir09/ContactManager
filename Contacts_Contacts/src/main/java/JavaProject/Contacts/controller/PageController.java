package JavaProject.Contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import JavaProject.Contacts.forms.UserForm;

@Controller
public class PageController {
    
    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("home done");
        model.addAttribute("name", "Contact Manager");
        return "home";
    }
    
    @GetMapping("/about")
    public String aboutpage() {
        System.out.println("about page");
        return "about";
    }
    
    @GetMapping("/services")
    public String servicespage() {
        System.out.println("services page");
        return "services";
    }
    
    @GetMapping("/contact")
    public String contactpage() {
        System.out.println("contact page");
        return "contactus";
    }
    
    @GetMapping("/login")
    public String loginpage() {
        System.out.println("login page");
        return "login";
    }
    
    @GetMapping("/signup")
    public String registerpage(Model model) {
        System.out.println("signup page");
        UserForm uf = new UserForm();
        //uf.setName("raj");
        model.addAttribute("userForm", uf);
        return "signup";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processregister(@ModelAttribute UserForm userForm) {
        System.out.println(userForm);
        
        return "redirect:/signup";
    }
}

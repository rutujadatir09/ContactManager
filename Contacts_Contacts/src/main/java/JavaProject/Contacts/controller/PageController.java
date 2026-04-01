package JavaProject.Contacts.controller;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.forms.UserForm;
import JavaProject.Contacts.helper.Message;
import JavaProject.Contacts.helper.MessageType;
import JavaProject.Contacts.service.userService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

	@Autowired
    private userService userService;

	@GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home done");
        model.addAttribute("name", "Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutpage() {
        System.out.println("about page");
        return "about";
    }

    @RequestMapping("/services")
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
    public String processregister(@Valid @ModelAttribute UserForm userForm,
                                  BindingResult rBindingResult,
                                  HttpSession session) {

        System.out.println(userForm);

        if (rBindingResult.hasErrors()) {
            return "signup";
        }

        userApp user = new userApp();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneno(userForm.getPhoneno());

        user.setEnabled(false);
        user.setEmailVerified(false);
        user.setProfile("");

        userApp savedUser = userService.saveUser(user);

        System.out.println("user saved : " + savedUser.getEmail());

        Message message = Message.builder()
                .content("Registration Successful. Please check your email for verification link.")
                .type(MessageType.blue)
                .build();

        session.setAttribute("message", message);

        return "redirect:/signup";
    }
}

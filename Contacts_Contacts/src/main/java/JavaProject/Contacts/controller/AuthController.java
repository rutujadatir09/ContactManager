package JavaProject.Contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.helper.Message;
import JavaProject.Contacts.helper.MessageType;
import JavaProject.Contacts.repo.userRepo;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private userRepo userRepo;

    @GetMapping("/verify-email")
    public String verifyEmail(@RequestParam("token") String token, HttpSession session) {

        userApp user = userRepo.findByEmailToken(token).orElse(null);

        if (user != null && user.getEmailToken() != null && user.getEmailToken().equals(token)) {

            user.setEmailVerified(true);
            user.setEnabled(true);
            user.setEmailToken(null);
            userRepo.save(user);

            session.setAttribute("message", Message.builder()
                    .type(MessageType.green)
                    .content("Your email is verified. Now you can login.")
                    .build());

            return "success_page";
        }

        session.setAttribute("message", Message.builder()
                .type(MessageType.red)
                .content("Email not verified! Invalid token.")
                .build());

        return "error_page";
    }
}
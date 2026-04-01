package JavaProject.Contacts.service;

import org.springframework.stereotype.Service;

public interface EmailService {
	
	void sendEmail(String to, String subject, String body);

    
    void sendEmailWithHtml();

    
    void sendEmailWithAttachment();

}

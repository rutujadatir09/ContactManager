package JavaProject.Contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.Contacts.entities.Contact;
import JavaProject.Contacts.service.ContactService;

@RestController
public class ApiController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable String contactId) {
        return contactService.getById(contactId);
    }
}
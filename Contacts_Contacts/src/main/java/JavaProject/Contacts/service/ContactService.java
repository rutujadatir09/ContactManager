package JavaProject.Contacts.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import JavaProject.Contacts.entities.Contact;
import JavaProject.Contacts.entities.userApp;

public interface ContactService {
	
	Contact save(Contact contact);

    // update contact
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    // get contact by id

    Contact getById(String contactId);

    // delete contact

    void delete(String contactId);

    // search contact
    Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String order, userApp user);

    Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String order, userApp user);

    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy, String order,
            userApp user);

    // get contacts by userId
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(userApp user, int page, int size, String sortField, String sortDirection);

}

package JavaProject.Contacts.repo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JavaProject.Contacts.entities.Contact;
import JavaProject.Contacts.entities.userApp;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {

    Page<Contact> findByUser(userApp user, Pageable pageable);

    @Query("SELECT c FROM Contact c WHERE c.user.id = :userId")
    List<Contact> findByUserId(@Param("userId") String userId);

    Page<Contact> findByUserAndNameContaining(userApp user, String nameKeyword, Pageable pageable);

    Page<Contact> findByUserAndEmailContaining(userApp user, String emailKeyword, Pageable pageable);

    Page<Contact> findByUserAndPhonenoContaining(userApp user, String phoneno, Pageable pageable);
}
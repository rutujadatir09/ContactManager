 package JavaProject.Contacts.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JavaProject.Contacts.entities.userApp;


@Repository
public interface userRepo extends JpaRepository<userApp, String>{

	Optional<userApp> findByEmail(String email);
	Optional<userApp> findByEmailAndPassword(String email, String password);
	Optional<userApp> findByEmailToken(String id);
	//Optional<userApp> findByEmailToken(String token);
}

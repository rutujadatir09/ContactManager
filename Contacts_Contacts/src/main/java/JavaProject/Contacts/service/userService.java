package JavaProject.Contacts.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import JavaProject.Contacts.entities.userApp;

public interface userService {
	
	 	userApp saveUser(userApp user);

	 	//if user present then do opertations if not throw error
	 	
	    Optional<userApp> getUserById(String id);

	    Optional<userApp> updateUser(userApp user);

	    void deleteUser(String id);

	    boolean isUserExist(String userId);

	    boolean isUserExistByEmail(String email);

	    List<userApp> getAllUsers();

	    //userApp getUserByEmail(String email);


}

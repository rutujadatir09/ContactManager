package JavaProject.Contacts.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.helper.ResourcesNotFoundException;
import JavaProject.Contacts.repo.userRepo;
import JavaProject.Contacts.service.userService;

@Service
public class userServiceImpl implements userService{


	@Autowired
	private userRepo userRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public userApp saveUser(userApp user) {
		// TODO Auto-generated method stub
		String userId = UUID.randomUUID().toString();
		user.setId(userId);
		
		return userRepo.save(user);
	}

	@Override
	public Optional<userApp> getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public Optional<userApp> updateUser(userApp user) {
		// TODO Auto-generated method stub
		userApp user1 = userRepo.findById(user.getId())
					.orElseThrow(() -> new ResourcesNotFoundException("User not found"));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setPhoneno(user.getPhoneno());
		user1.setAbout(user.getAbout());
		user1.setEnable(user.isEnable());
		user1.setProfile(user.getProfile());
		user1.setEmailVerified(user.isEmailVerified());
		user1.setPhoneVerified(user.isPhoneVerified());
		user1.setProvider(user.getProvider());
		user1.setProviderUserIdString(user.getProviderUserIdString());
		userApp save = userRepo.save(user1);
		return Optional.ofNullable(save);
	}

	@Override
	public void deleteUser(String id) {
		
		userApp user1 = userRepo.findById(id)
				.orElseThrow(() ->  new ResourcesNotFoundException("User not found"));
		          userRepo.delete(user1);
		
	}

	@Override
	public boolean isUserExist(String userId) {
		// TODO Auto-generated method stub
		userApp user1 = userRepo.findById(userId).orElse(null);
		return user1 != null ? true : false;
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		// TODO Auto-generated method stub
		userApp user1 = userRepo.findByEmail(email).orElse(null);
		return user1 != null ? true : false;
	}

	@Override
	public List<userApp> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}

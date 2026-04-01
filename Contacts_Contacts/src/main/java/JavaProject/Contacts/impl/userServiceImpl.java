package JavaProject.Contacts.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JavaProject.Contacts.entities.userApp;
import JavaProject.Contacts.helper.AppConstants;
import JavaProject.Contacts.helper.ResourcesNotFoundException;
import JavaProject.Contacts.repo.userRepo;
import JavaProject.Contacts.service.EmailService;
import JavaProject.Contacts.service.userService;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public userApp saveUser(userApp user) {

        String userId = UUID.randomUUID().toString();
        user.setId(userId);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoleList(List.of(AppConstants.ROLE_USER));

        user.setEnabled(false);
        user.setEmailVerified(false);

        String emailToken = UUID.randomUUID().toString();
        user.setEmailToken(emailToken);

        logger.info(user.getProvider().toString());

        userApp savedUser = userRepo.save(user);

        String verificationLink = "http://localhost:8081/verify-email?token=" + emailToken;

        emailService.sendEmail(
                user.getEmail(),
                "Verify Your Email",
                "Hello " + user.getName() + ",\n\n"
                        + "Please click the link below to verify your email:\n"
                        + verificationLink + "\n\n"
                        + "Thank you!"
        );

        return savedUser;
    }

    @Override
    public Optional<userApp> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<userApp> updateUser(userApp user) {
        userApp user1 = userRepo.findById(user.getId())
                .orElseThrow(() -> new ResourcesNotFoundException("User not found"));

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setPhoneno(user.getPhoneno());
        user1.setAbout(user.getAbout());
        user1.setEnabled(user.isEnabled());
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
                .orElseThrow(() -> new ResourcesNotFoundException("User not found"));
        userRepo.delete(user1);
    }

    @Override
    public boolean isUserExist(String userId) {
        userApp user1 = userRepo.findById(userId).orElse(null);
        return user1 != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        userApp user1 = userRepo.findByEmail(email).orElse(null);
        return user1 != null;
    }

    @Override
    public List<userApp> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public userApp getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
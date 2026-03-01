package JavaProject.Contacts.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import JavaProject.Contacts.repo.userRepo;


@Service
public class SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private userRepo userRepo1;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        return userRepo1.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + username));

    }

}
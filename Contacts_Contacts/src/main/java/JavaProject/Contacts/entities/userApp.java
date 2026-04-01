package JavaProject.Contacts.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class userApp implements UserDetails{

    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    @Getter(AccessLevel.NONE)
    private String password;

    @Column(length = 1000)
    private String about;

    private String profile;

    @Column(length = 10)
    private String phoneno;
    
    @Column(name = "enabled")
     @Getter(value = AccessLevel.NONE)
     
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    private providers provider = providers.self;

    private String providerUserIdString;

    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    private List<Contact> contacts = new ArrayList<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();
    
    private String emailToken;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return roles;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	
	
	
}

package JavaProject.Contacts.entities;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userApp{
	
	// imp user info
	@Id
	private long id;
	@Column(name = "user_name" , nullable = false )
	private String name;
	@Column(unique = true , nullable = false)
	private String email;
	private String password;
	@Column(length = 1000)
	private String about;
	
	private String profile;
	@Column(length = 10)
	private String phone;
	
	//verified or not 
	private boolean enable = false;
	private boolean emailVerified = false;
	private boolean phoneVerified = false;
	
	// login with external apps
	private String provider;
	private String providerUserIdString;
	
	
	//for one to many  cascade for if user is deleted contacts will be deleted
	//fetch for untill and unless we dont need contacts we will not use query in database
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true)
	private List<Contact> contacts = new ArrayList<>();
	
	
	

}

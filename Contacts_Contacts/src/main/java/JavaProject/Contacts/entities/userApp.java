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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userApp{
	
	// imp user info
	@Id
	private String id;
	@Column(name = "user_name" , nullable = false )
	private String name;
	@Column(unique = true , nullable = false)
	private String email;
	private String password;
	@Column(length = 1000)
	private String about;
	
	private String profile;
	@Column(length = 10)
	private String phoneno;
	
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


	public String getId() {
		return id;
	}


	public void setId(String userId) {
		this.id = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public boolean isEmailVerified() {
		return emailVerified;
	}


	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}


	public boolean isPhoneVerified() {
		return phoneVerified;
	}


	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getProviderUserIdString() {
		return providerUserIdString;
	}


	public void setProviderUserIdString(String providerUserIdString) {
		this.providerUserIdString = providerUserIdString;
	}


	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	
	

}

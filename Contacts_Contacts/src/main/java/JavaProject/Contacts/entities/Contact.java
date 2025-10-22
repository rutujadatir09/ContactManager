package JavaProject.Contacts.entities;

import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	private String picture;
	@Column(length = 1000)
	private String description;
	private boolean fav = false;
	private String weblink;
	//private String facebooklink;
	//private String twitterlink;
	
	private String linkedinLink;
	
	@ManyToOne
	private userApp user;
	
	@OneToMany(mappedBy = "contact" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
	private List<links> sociallinks = new ArrayList<>();

}

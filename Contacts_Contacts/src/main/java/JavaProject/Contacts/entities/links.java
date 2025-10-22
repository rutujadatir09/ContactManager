package JavaProject.Contacts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class links {
	
	@Id
	private long id;
	private String link;
	private String title;
	
	@ManyToOne
	private Contact contact;

}

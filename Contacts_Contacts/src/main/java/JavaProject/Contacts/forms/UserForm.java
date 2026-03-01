package JavaProject.Contacts.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserForm {

	@NotBlank(message = "Username is required")
	@Size(min = 3 , message = "Min 3 characters is required")
	private String name;
	
	@Email(message = "Invalid Email")
	private String email;
	
	@NotBlank(message = "password is required")
	@Size(min = 6 , message = "Min 6 characters is required")
	private String password;
	
	@Size(min = 10 , max = 10 , message = "Invalid Phone number")
	private String phoneno;
	



}

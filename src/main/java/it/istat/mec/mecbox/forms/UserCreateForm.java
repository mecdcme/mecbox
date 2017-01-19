package it.istat.mec.mecbox.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;




 

public class UserCreateForm {

	 @NotNull
	@Email
    private String email = "";

	 @NotNull
	 @Size(min=2, max=30)
    private String password = "";
    
   
	 @NotNull
	 @Size(min=2, max=30)
    private String fullname;
  

 
    private String role ;;
    
    public String toString() {
        return "Person(Email: " + this.email + ", fullName: " + this.fullname + ")";
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

	 

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	 
}

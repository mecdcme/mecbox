package it.istat.mec.mecbox.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 

 

 

@Entity
@Table(name = "users")
public class User implements Serializable {

 private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="userid")
    private Long userid;

 

 @Column(name = "password")
    private String password;   

 @Column(name = "email",unique=true)
     private String email;
    
 
 @Column(name = "fullname", length = 100)
 private String fullname;

 

<<<<<<< Upstream, based on branch 'develop' of https://github.com/mecdcme/mecbox.git
@OneToOne(mappedBy = "user",orphanRemoval = true)
@JsonManagedReference
=======
@OneToOne(mappedBy = "user",fetch=FetchType.EAGER)
@JsonBackReference
>>>>>>> 95d47ae s
private UserRole role; 
 




public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
}




 
 public User(){
	 
  
 }
 
 public User(User user) {
         this.userid = user.userid;
       
         this.email = user.email;       
         this.password = user.password;
           
 }
 
 
 

 public Long getUserid() {
  return userid;
 }

 public void setUserid(Long userid) {
  this.userid = userid;
 }
 
 public String getPassword() {
  return password;
 }

 
 public void setPassword(String password) {
  this.password = password;
 }
 
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }





 
 public User(String email, String fullname) {
     this.email = email;
  
 }

 public User(Long userid, String email, String fullname) {
     this.userid = userid;
     this.email = email;
    
 }

 @Override
 public String toString() {
     return "User{" +
             "id=" + userid +
             ", email='" + email + '\'' +
             ", passwordHash='" + password + '\'' +
          
             '}';
 }

public UserRole getRole() {
	return role;
}

public void setRole(UserRole role) {
	this.role = role;
}

 


}
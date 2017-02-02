package it.istat.mec.mecbox.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.istat.mec.mecbox.domain.User;;

@Entity
@Table(name="user_roles")
public class UserRole {
 
 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="user_role_id")
 private Long userroleid;
 
  
 public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

// 

@OneToOne
 @JoinColumn(name="userid")

 private User user;
 
 @Column(name="role")
 private String role; 

 public String getRole() {
  return role;
 }

 public void setRole(String role) {
  this.role = role;
 }

 
 public Long getUserroleid() {
  return userroleid;
 }

 public void setUserroleid(Long userroleid) {
  this.userroleid = userroleid;
 } 
 
}
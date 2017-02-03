package it.istat.mec.mecbox.services;

 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import it.istat.mec.mecbox.dao.UserDao;
import it.istat.mec.mecbox.dao.UserRolesDao;
import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.security.CustomUserDetails;

 
 
 
//@Service("customUserDetailsService")
@Service
public class CustomUserDetailsService implements UserDetailsService{
 private final UserDao userDao;
 private final UserRolesDao userRolesDao;
 
 @Autowired
 private NotificationService notificationService;
 
 @Autowired
 private  AuthenticationManager am;
  
 @Autowired
    public CustomUserDetailsService(UserDao userDao,UserRolesDao userRolesDao) {
        this.userDao = userDao;
        this.userRolesDao=userRolesDao;
    }
  
         
 @Override
 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  User user=userDao.findByEmail(email);
  CustomUserDetails cud;
  if(null == user){
	  {
		  notificationService.addErrorMessage("Nessun user presente con  user: "+email);
   throw new UsernameNotFoundException("No user present with user: "+email);
	  }
  }else{
   List<String> userRoles=userRolesDao.findRoleByEmail(email);
 //  notificationService.addInfoMessage("Benvenuto!");
   cud= new CustomUserDetails(user,userRoles);
   
   return cud;
  }
 }
   
  public void authenticate (String name, Object password)
  {
	  Authentication request = new UsernamePasswordAuthenticationToken(name, password);
			Authentication result = am.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		
  }
  
 
}
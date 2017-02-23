package it.istat.mec.mecbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.istat.mec.mecbox.dao.UserDao;
import it.istat.mec.mecbox.dao.UserRolesDao;
import it.istat.mec.mecbox.domain.User;
import it.istat.mec.mecbox.domain.UserRole;
import it.istat.mec.mecbox.forms.UserCreateForm;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRolesDao userRolesDao;

	// @Autowired
	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) this.userDao.findAll();
	}

	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return this.userDao.findOne(id);
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userDao.findByEmail(email);
	}

	@Transactional
	public User create(UserCreateForm uf) {
		// TODO Auto-generated method stub a
		User user = new User();
		user.setEmail(uf.getEmail());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(uf.getPassword()));

		user.setName(uf.getName());
		user.setSurname(uf.getSurname());
		UserRole ur = new UserRole();

		ur.setRole(uf.getRole());
		user.setRole(ur);
		userDao.save(user);
		ur.setUser(user);
		userRolesDao.save(ur);

		return user;

	}

	@Transactional
	public User update(UserCreateForm uf) throws Exception {
		// TODO Auto-generated method stub a
		User user = userDao.findOne(uf.getUserid());
		if (user == null)
			throw new Exception("User not found");
		user.setEmail(uf.getEmail());
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// user.setPassword(passwordEncoder.encode(uf.getPassword()));
		// user.setPassword(uf.getPassword());
		user.setName(uf.getName());
		user.setSurname(uf.getSurname());
		//user.setPassword(null);
		UserRole ur = user.getRole();
		ur.setRole(uf.getRole());
		//user.setRole(ur);
		userDao.save(user);
		//ur.setUser(user);
		userRolesDao.save(ur);
		return user;

	}
	
	 
	public User updatePasswordByEmail(String email,String password) throws Exception {
		// TODO Auto-generated method stub a
		User user = userDao.findByEmail(email); 
		if (user == null)
			throw new Exception("User not found");
		
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 user.setPassword(passwordEncoder.encode(password));
	    userDao.save(user);
	 	return user;
 	}
	public User updatePasswordById(Long id,String password) throws Exception {
		// TODO Auto-generated method stub a
		User user = userDao.findOne(id); 
		if (user == null)
			throw new Exception("User not found");
		
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 user.setPassword(passwordEncoder.encode(password));
	    userDao.save(user);
	 	return user;
 	}

	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub a
		userDao.delete(id);

	}

}

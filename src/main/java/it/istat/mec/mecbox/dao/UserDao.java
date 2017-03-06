package it.istat.mec.mecbox.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.istat.mec.mecbox.domain.User;

/**
 *
 * @author Istat MecBox Team
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    public User findByEmail(String email);

}

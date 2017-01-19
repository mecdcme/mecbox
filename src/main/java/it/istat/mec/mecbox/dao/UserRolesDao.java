package it.istat.mec.mecbox.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.istat.mec.mecbox.domain.UserRole;


@Repository
public interface UserRolesDao extends CrudRepository<UserRole,Long> {
 
    @Query("select a.role from UserRole a, User b where b.email=?1 and a.user.userid=b.userid")
    public List<String> findRoleByEmail(String email);
 
}

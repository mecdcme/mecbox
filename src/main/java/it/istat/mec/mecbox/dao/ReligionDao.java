package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Religion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Istat MecBox Team
 */
@Repository
public interface ReligionDao extends CrudRepository<Religion, Long> {

}

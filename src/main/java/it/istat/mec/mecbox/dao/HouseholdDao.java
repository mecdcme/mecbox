package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Household;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Istat MecBox Team
 */
@Repository
public interface HouseholdDao extends CrudRepository<Household, Long> {

}

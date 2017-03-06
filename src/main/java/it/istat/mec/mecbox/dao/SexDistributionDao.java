package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.SexDistribution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Istat MecBox Team
 */
@Repository
public interface SexDistributionDao extends CrudRepository<SexDistribution, Long> {

}

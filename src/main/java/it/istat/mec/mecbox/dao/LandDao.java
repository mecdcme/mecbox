package it.istat.mec.mecbox.dao;

import it.istat.mec.mecbox.domain.Land;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Istat MecBox Team
 */
@Repository
public interface LandDao extends CrudRepository<Land, Long> {

	@Query("select a from Land a where a.regione=?1")
    public List<Land> findLandbyReg(String regione);
	
	@Query("select a from Land a where a.provincia=?1")
    public List<Land> findLandbyProv(String provincia);
	
	public List<Land> findByProvincia(String provincia);
}

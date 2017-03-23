package it.istat.mec.mecbox.dao;

/**
 * Copyright 2017 ISTAT
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence. You may
 * obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations under
 * the Licence.
 *
 * @author Francesco Amato <framato @ istat.it>
 * @author Mauro Bruno <mbruno @ istat.it>
 * @author Stefano Macone <stefano.macone @ istat.it>
 * @author Andrea Pagano <andrea.pagano @ istat.it>
 * @author Paolo Pizzo <papizzo @ istat.it>
 * @version 1.0
 */

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.istat.mec.mecbox.domain.UserRole;


@Repository
public interface UserRolesDao extends CrudRepository<UserRole, Long> {

    @Query("select a.role from UserRole a, User b where b.email=?1 and a.user.userid=b.userid")
    public List<String> findRoleByEmail(String email);

}

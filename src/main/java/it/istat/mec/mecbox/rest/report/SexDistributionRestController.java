package it.istat.mec.mecbox.rest.report;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.mecbox.domain.SexDistribution;
import it.istat.mec.mecbox.services.report.SexDistributionService;


@RestController
public class SexDistributionRestController {

    @Autowired
    private SexDistributionService sexdistributionService;

    @RequestMapping(value = "/sexdistribution/restlist")
    public List<SexDistribution> sexdistributionlist(Model model) {

        List<SexDistribution> sexdistribution = sexdistributionService.findAll();
        return sexdistribution;
    }

}

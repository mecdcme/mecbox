package it.istat.mec.mecbox.rest.territory;

import it.istat.mec.mecbox.domain.Comune;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.mecbox.domain.Regione;
import it.istat.mec.mecbox.domain.Provincia;
import it.istat.mec.mecbox.services.report.TerritoryService;

/*
 * @author Istat MecBox Team
 */
@RestController
public class TerritoryRestController {

    @Autowired
    private TerritoryService territoryService;       
    
    /* regione all,  cod reg, nome */
    @GetMapping(value = "/territory/regione")
    public List<Regione> regioneList(Model model) {
        List<Regione> reg = territoryService.regioneFindAll();
        return reg;
    }    
    /* list regione by cod reg*/    
    @GetMapping(value = "/territory/regione/{codReg}")
    public Regione regioneByCodReg(@PathVariable int codReg) {
        Regione reg = territoryService.findByCodReg(codReg);
        return reg;        
    }        
    /* list by nome */
    @GetMapping(value = "/territory/regionenome/{regione}")
    public Regione regioneNome(@PathVariable String regione) {
        Regione reg = territoryService.findByRegione(regione);
        return reg;        
    }    
    
    /* province all, cod reg*/      
    @GetMapping(value = "/territory/provincia")
    public List<Provincia> provinciaList(Model model) {
        List<Provincia> pro = territoryService.provinciaFindAll();
        return pro;
    }    
    @GetMapping(value = "/territory/regione/{codReg}/provincia")
    public List<Provincia> provinciaByCodReg(@PathVariable Integer codReg) {
        List<Provincia> pro = territoryService.findProvinciaByCodReg(codReg);
        return pro;
    } 
        
    /* comune all, cod reg cod pro*/          
    @GetMapping(value = "/territory/comune")
    public List<Comune> comuneList(Model model) {
        List<Comune> com = territoryService.comuneFindAll();
        return com;
    }        
    @GetMapping(value = "/territory/regione/{codReg}/provincia/{codPro}")
    public List<Comune> comuneByCodRegAndCodPro(@PathVariable Integer codReg,@PathVariable Integer codPro) {
        List<Comune> com = territoryService.findComumeByCodRegAndCodPro(codReg, codPro);
        return com;
    }    
    
    /*
    @GetMapping(value = "/territory/regione/{codReg}/provincia")
    public  List<Provincia> provinciaByCodReg2(@PathVariable int codReg) {
        List<Provincia> pro =  territoryService.findProvinciaByCodReg(codReg);
        return pro;        
    }
    */
    
   
}

package com.tickets.web.controllers.recintos;

import com.tickets.api.entitys.catalogos.recintos.Asiento;
import com.tickets.services.catalogos.recintos.AsientoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/asientos")
public class AsientoController {
    
   @Resource
   AsientoService asientoService;
   
    @RequestMapping(value = "/altaAsiento", method = RequestMethod.POST)
    public @ResponseBody Asiento altaAsiento(@RequestBody Asiento asiento) {
        return asientoService.altaAsiento(asiento);
    }
    
    @RequestMapping(value = "/consultaAsiento", method = RequestMethod.POST)
    public @ResponseBody List<Asiento> consultaAsiento() {
        return asientoService.consultaAsientosList();
    }
    
    @RequestMapping(value = "/bajaAsiento", method = RequestMethod.POST)
    public @ResponseBody boolean bajaAsiento(@RequestBody Integer id) {
        asientoService.bajaAsiento(id);
        return true;
    }
}

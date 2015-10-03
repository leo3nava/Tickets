package com.tickets.web.controllers.recintos;

import com.tickets.api.entitys.catalogos.recintos.Zona;
import com.tickets.services.catalogos.recintos.ZonaService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/zonas")
public class ZonaController {
    
   @Resource
   ZonaService zonaService;
   
    @RequestMapping(value = "/altaZona", method = RequestMethod.POST)
    public @ResponseBody Zona altaZona(@RequestBody Zona zona) {
        return zonaService.altaZona(zona);
    }
    
    @RequestMapping(value = "/consultaZona", method = RequestMethod.POST)
    public @ResponseBody List<Zona> consultaZona() {
        return zonaService.consultaZonasList();
    }
    
    @RequestMapping(value = "/bajaZona", method = RequestMethod.POST)
    public @ResponseBody boolean bajaZona(@RequestBody Integer id) {
        zonaService.bajaZona(id);
        return true;
    }
}

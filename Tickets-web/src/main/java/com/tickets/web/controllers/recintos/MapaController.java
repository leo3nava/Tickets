package com.tickets.web.controllers.recintos;

import com.tickets.api.entitys.catalogos.recintos.Mapa;
import com.tickets.services.catalogos.recintos.MapaService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapas")
public class MapaController {
    
   @Resource
   MapaService mapaService;
   
    @RequestMapping(value = "/altaMapa", method = RequestMethod.POST)
    public @ResponseBody Mapa altaMapa(@RequestBody Mapa mapa) {
        return mapaService.altaMapa(mapa);
    }
    
    @RequestMapping(value = "/consultaMapa", method = RequestMethod.POST)
    public @ResponseBody List<Mapa> consultaMapa() {
        List<Mapa> mapaList = mapaService.consultaMapasList();
        for(Mapa mapa : mapaList){
            System.out.println("mapa " + mapa.getRecinto().getNombre());
        }
        return mapaList;
    }
    
    @RequestMapping(value = "/bajaMapa", method = RequestMethod.POST)
    public @ResponseBody boolean bajaMapa(@RequestBody Integer id) {
        mapaService.bajaMapa(id);
        return true;
    }
}

package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.services.catalogos.EventoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/eventos")
public class EventosController {
    
   @Resource
   EventoService eventoService;
   
    @RequestMapping(value = "/altaEvento", method = RequestMethod.POST)
    public @ResponseBody Evento altaEvento(@RequestBody Evento evento) {
        return eventoService.altaEvento(evento);
    }
    
    @RequestMapping(value = "/consultaEvento", method = RequestMethod.POST)
    public @ResponseBody List<Evento> consultaEvento() {
        return eventoService.consultaEventosList();
    }
    
    @RequestMapping(value = "/bajaEvento", method = RequestMethod.POST)
    public @ResponseBody boolean bajaEvento(@RequestBody Integer id) {
        eventoService.bajaEvento(id);
        return true;
    }
}

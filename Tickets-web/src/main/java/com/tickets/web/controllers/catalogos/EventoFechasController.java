package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.EventoFechas;
import com.tickets.services.catalogos.EventoFechasService;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/eventoFechas")
public class EventoFechasController {

    @Resource
    EventoFechasService eventoFechasService;
    /*
     @RequestMapping(value = "/altaEventoFechas", method = RequestMethod.POST)
     public @ResponseBody EventoFechas altaEvento(@RequestBody EventoFechas eventoFechas) {
     return eventoFechasService.altaEventoFechas(eventoFechas);
     }*/

    @RequestMapping(value = "/consultaEventoFechas", method = RequestMethod.POST)
    public @ResponseBody
    List<EventoFechas> consultaEvento() {
        return eventoFechasService.consultaEventoFechasList();
    }

    @RequestMapping(value = "/bajaEventoFechas", method = RequestMethod.POST)
    public @ResponseBody
    boolean bajaEventoFechas(@RequestBody Integer id) {
        eventoFechasService.bajaEventoFechas(id);
        return true;
    }

    @RequestMapping(value = "/altaEventoFechas", method = RequestMethod.POST)
    public @ResponseBody
    EventoFechas altaEvento(MultipartHttpServletRequest request, HttpServletResponse response) {

        EventoFechas eventoFechas = new EventoFechas();
        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() + " uploaded!");

        try {
            eventoFechas.setActivo(1);
            eventoFechas.setTipoVentasId(1);
            eventoFechas.setImagenEvento(mpf.getBytes());
            eventoFechas.setNumeroEvento(1);
            //just temporary save file info into ufile
            System.out.println("lenght" + mpf.getBytes().length);
            /*ufile.length = mpf.getBytes().length;
            ufile.bytes = mpf.getBytes();
            ufile.type = mpf.getContentType();
            ufile.name = mpf.getOriginalFilename();*/

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return eventoFechasService.altaEventoFechas(eventoFechas);
    }
}

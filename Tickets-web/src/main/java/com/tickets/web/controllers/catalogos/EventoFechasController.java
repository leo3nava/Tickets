package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.api.entitys.catalogos.EventoFechas;
import com.tickets.services.catalogos.EventoFechasService;
import java.text.SimpleDateFormat;
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

    @RequestMapping(value = "/altaEventoFechas", method = RequestMethod.POST)
    public @ResponseBody
    EventoFechas altaEventoFechas(@RequestBody EventoFechas eventoFechas) {
        return eventoFechasService.altaEventoFechas(eventoFechas);
    }

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

    @RequestMapping(value = "/altaEventoImagen", method = RequestMethod.POST)
    public @ResponseBody
    EventoFechas altaEventoImagen(MultipartHttpServletRequest request, HttpServletResponse response) {

        EventoFechas eventoFechas = new EventoFechas();
        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() + " uploaded!");

        try {
            System.out.println("Id " + request.getParameterValues("fechaEventoId")[0]);
            String id = request.getParameterValues("fechaEventoId")[0];
            if(id != null && !id.equals("")){
                eventoFechas.setId(Integer.parseInt(request.getParameterValues("fechaEventoId")[0]));
            }
            Evento evento = new Evento();
            evento.setId(Integer.parseInt(request.getParameterValues("cmbEvento")[0]));
            eventoFechas.setEvento(evento);
            
            eventoFechas.setActivo(Integer.parseInt(request.getParameterValues("activo")[0]));
            eventoFechas.setTipoVentasId(Integer.parseInt(request.getParameterValues("tipoVentasId")[0]));
            eventoFechas.setNumeroEvento(Integer.parseInt(request.getParameterValues("numeroEvento")[0]));
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
            eventoFechas.setFechaEvento(formatter.parse(request.getParameterValues("fechaEvento")[0]));
            eventoFechas.setFechaEventoAlterna(formatter.parse(request.getParameterValues("fechaEventoAlterna")[0]));
            eventoFechas.setFechaFinVenta(formatter.parse(request.getParameterValues("fechaFinVenta")[0]));
            eventoFechas.setFechaInicioVenta(formatter.parse(request.getParameterValues("fechaInicioVenta")[0]));
            
            eventoFechas.setImagenEvento(mpf.getBytes());
            //just temporary save file info into ufile
            System.out.println("lenght" + mpf.getBytes().length);
            /*ufile.length = mpf.getBytes().length;
             ufile.bytes = mpf.getBytes();
             ufile.type = mpf.getContentType();
             ufile.name = mpf.getOriginalFilename();*/

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return eventoFechasService.altaEventoFechas(eventoFechas);
    }
}

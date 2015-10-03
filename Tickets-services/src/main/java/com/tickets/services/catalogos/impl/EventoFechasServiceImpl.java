package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.api.entitys.catalogos.EventoFechas;
import com.tickets.dao.catalogos.EventoDao;
import com.tickets.dao.catalogos.EventoFechasDao;
import com.tickets.services.catalogos.EventoFechasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventoFechasServiceImpl implements EventoFechasService{

    @Autowired
    EventoFechasDao eventoFechasDao;
    
    @Autowired
    EventoDao eventoDao;
    
    @Override
    public EventoFechas altaEventoFechas(EventoFechas eventoFechas) {
        Evento evento = eventoDao.consultaEvento(eventoFechas.getEvento().getId());
        eventoFechas.setEvento(evento);
        evento.getEventoFechas().add(eventoFechas);
        return eventoFechasDao.altaEventoFechas(eventoFechas);
    }

    @Override
    public EventoFechas bajaEventoFechas(Integer idEventoFechas) {
        return eventoFechasDao.bajaEventoFechas(idEventoFechas);
    }
    

    @Override
    public EventoFechas actualizaEventoFechas(EventoFechas eventoFechas) {
        return eventoFechasDao.actualizaEventoFechas(eventoFechas);
    }
    
    @Override
    public List<EventoFechas> consultaEventoFechasList(){
        List<EventoFechas> eventoFechasList = eventoFechasDao.consultaEventoFechasList();

        
        return eventoFechasList;
        
    }
    
    @Override
    public EventoFechas consultaEventoFechas(Integer id){
        return eventoFechasDao.consultaEventoFechas(id);
    }

}

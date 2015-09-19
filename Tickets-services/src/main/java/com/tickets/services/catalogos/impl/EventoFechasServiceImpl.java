package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.EventoFechas;
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
    
    @Override
    public EventoFechas altaEventoFechas(EventoFechas usuario) {
        return eventoFechasDao.altaEventoFechas(usuario);
    }

    @Override
    public EventoFechas bajaEventoFechas(Integer idEventoFechas) {
        return eventoFechasDao.bajaEventoFechas(idEventoFechas);
    }
    

    @Override
    public EventoFechas actualizaEventoFechas(EventoFechas usuario) {
        return eventoFechasDao.actualizaEventoFechas(usuario);
    }
    
    @Override
    public List<EventoFechas> consultaEventoFechasList(){
        return eventoFechasDao.consultaEventoFechasList();
        
    }
    
    @Override
    public EventoFechas consultaEventoFechas(Integer id){
        return eventoFechasDao.consultaEventoFechas(id);
    }

}

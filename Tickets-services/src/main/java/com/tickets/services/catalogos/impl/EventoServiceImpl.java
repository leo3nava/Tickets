package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.api.entitys.catalogos.Recinto;
import com.tickets.dao.InventarioDao;
import com.tickets.dao.catalogos.EventoDao;
import com.tickets.dao.catalogos.RecintoDao;
import com.tickets.services.catalogos.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventoServiceImpl implements EventoService{

    @Autowired
    EventoDao eventoDao;
    
    @Autowired
    RecintoDao recintoDao;
    
    @Override
    public Evento altaEvento(Evento evento) {
        
        Recinto recinto = recintoDao.consultaRecinto(evento.getRecinto().getId());
        evento.setRecinto(recinto);
        return eventoDao.altaEvento(evento);
    }

    @Override
    public Evento bajaEvento(Integer idEvento) {
        return eventoDao.bajaEvento(idEvento);
    }

    @Override
    public Evento actualizaEvento(Evento evento) {
        return eventoDao.actualizaEvento(evento);
    }
    
    @Override
    public List<Evento> consultaEventosList(){
        return eventoDao.consultaEventosList();
        
    }
    
    @Override
    public Evento consultaEvento(Integer id){
        return eventoDao.consultaEvento(id);
    }

}

package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.dao.InventarioDao;
import com.tickets.dao.catalogos.EventoDao;
import com.tickets.services.catalogos.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventoServiceImpl implements EventoService{

    @Autowired
    EventoDao usuarioDao;
    
    @Autowired
    InventarioDao inventarioDao;
    
    @Override
    public Evento altaEvento(Evento usuario) {
        return usuarioDao.altaEvento(usuario);
    }

    @Override
    public Evento bajaEvento(Long idEvento) {
        return usuarioDao.bajaEvento(idEvento);
    }

    @Override
    public Evento actualizaEvento(Evento usuario) {
        return usuarioDao.actualizaEvento(usuario);
    }
    
    @Override
    public List<Evento> consultaEventosList(){
        return usuarioDao.consultaEventosList();
        
    }
    
    @Override
    public Evento consultaEvento(Long id){
        return usuarioDao.consultaEvento(id);
    }

}

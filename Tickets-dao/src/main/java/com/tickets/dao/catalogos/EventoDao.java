package com.tickets.dao.catalogos;

import com.tickets.api.entitys.catalogos.Evento;
import java.util.List;

public interface EventoDao {
    
    public Evento altaEvento(Evento evento);
    
    public Evento actualizaEvento(Evento evento);
    
    public Evento bajaEvento(Integer id);
    
    public List<Evento> consultaEventosList();
    
    public Evento consultaEvento(Integer id);
    
}

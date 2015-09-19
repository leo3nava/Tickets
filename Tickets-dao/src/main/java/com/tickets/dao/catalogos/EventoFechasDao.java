package com.tickets.dao.catalogos;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.api.entitys.catalogos.EventoFechas;
import java.util.List;

public interface EventoFechasDao {
    
    public EventoFechas altaEventoFechas(EventoFechas eventoFechas);
    
    public EventoFechas actualizaEventoFechas(EventoFechas eventoFechas);
    
    public EventoFechas bajaEventoFechas(Integer id);
    
    public List<EventoFechas> consultaEventoFechasList();
    
    public EventoFechas consultaEventoFechas(Integer id);
    
}

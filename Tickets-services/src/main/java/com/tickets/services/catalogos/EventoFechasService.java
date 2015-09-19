package com.tickets.services.catalogos;

import com.tickets.api.entitys.catalogos.EventoFechas;
import java.util.List;

public interface EventoFechasService {  
    
    public EventoFechas altaEventoFechas(EventoFechas usuario);
    
    public EventoFechas actualizaEventoFechas(EventoFechas usuario);
    
    public EventoFechas bajaEventoFechas(Integer id);
    
    public List<EventoFechas> consultaEventoFechasList();
    
    public EventoFechas consultaEventoFechas(Integer id);
    
}

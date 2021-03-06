package com.tickets.services.catalogos;

import com.tickets.api.entitys.catalogos.Evento;
import java.util.List;

public interface EventoService {  
    
    public Evento altaEvento(Evento usuario);
    
    public Evento actualizaEvento(Evento usuario);
    
    public Evento bajaEvento(Integer id);
    
    public List<Evento> consultaEventosList();
    
    public Evento consultaEvento(Integer id);
    
}

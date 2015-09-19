package com.tickets.services.catalogos;

import com.tickets.api.entitys.catalogos.Recinto;
import java.util.List;

public interface RecintoService {  
    
    public Recinto altaRecinto(Recinto recinto);
    
    public Recinto actualizaRecinto(Recinto recinto);
    
    public Recinto bajaRecinto(Integer id);
    
    public List<Recinto> consultaRecintoList();
    
    public Recinto consultaRecinto(Integer id);
    
}

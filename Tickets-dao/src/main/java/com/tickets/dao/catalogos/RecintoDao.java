package com.tickets.dao.catalogos;

import com.tickets.api.entitys.catalogos.Recinto;
import java.util.List;

public interface RecintoDao {
    
    public Recinto altaRecinto(Recinto recinto);
    
    public Recinto actualizaRecinto(Recinto recinto);
    
    public Recinto bajaRecinto(Integer id);
    
    public List<Recinto> consultaRecintoList();
    
    public Recinto consultaRecinto(Integer id);
    
}

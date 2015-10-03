package com.tickets.dao.catalogos.recintos;

import com.tickets.api.entitys.catalogos.recintos.Zona;
import java.util.List;

public interface ZonaDao {
    
    public Zona altaZona(Zona zona);
    
    public Zona actualizaZona(Zona zona);
    
    public Zona bajaZona(Integer id);
    
    public List<Zona> consultaZonasList();
    
    public Zona consultaZona(Integer id);
    
}

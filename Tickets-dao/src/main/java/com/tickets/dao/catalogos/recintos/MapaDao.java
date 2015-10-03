package com.tickets.dao.catalogos.recintos;

import com.tickets.api.entitys.catalogos.recintos.Mapa;
import java.util.List;

public interface MapaDao {
    
    public Mapa altaMapa(Mapa mapa);
    
    public Mapa actualizaMapa(Mapa mapa);
    
    public Mapa bajaMapa(Integer id);
    
    public List<Mapa> consultaMapasList();
    
    public Mapa consultaMapa(Integer id);
    
}

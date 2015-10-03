package com.tickets.services.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.Recinto;
import com.tickets.api.entitys.catalogos.recintos.Mapa;
import com.tickets.dao.catalogos.RecintoDao;
import com.tickets.dao.catalogos.recintos.MapaDao;
import com.tickets.services.catalogos.recintos.MapaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MapaServiceImpl implements MapaService{

    @Autowired
    MapaDao mapaDao;
    
    @Autowired
    RecintoDao recintoDao;
    
    @Override
    public Mapa altaMapa(Mapa mapa) {
        
        Recinto recinto = recintoDao.consultaRecinto(mapa.getRecinto().getId());
        mapa.setRecinto(recinto);
        return mapaDao.altaMapa(mapa);
    }

    @Override
    public Mapa bajaMapa(Integer idMapa) {
        return mapaDao.bajaMapa(idMapa);
    }

    @Override
    public Mapa actualizaMapa(Mapa mapa) {
        return mapaDao.actualizaMapa(mapa);
    }
    
    @Override
    public List<Mapa> consultaMapasList(){
        return mapaDao.consultaMapasList();
        
    }
    
    @Override
    public Mapa consultaMapa(Integer id){
        return mapaDao.consultaMapa(id);
    }

}

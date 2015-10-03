package com.tickets.services.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.recintos.Mapa;
import com.tickets.api.entitys.catalogos.recintos.Zona;
import com.tickets.dao.catalogos.recintos.MapaDao;
import com.tickets.dao.catalogos.recintos.ZonaDao;
import com.tickets.services.catalogos.recintos.ZonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ZonaServiceImpl implements ZonaService{

    @Autowired
    ZonaDao zonaDao;
    
    @Autowired
    MapaDao mapaDao;
    
    @Override
    public Zona altaZona(Zona zona) {
        
        Mapa mapa = mapaDao.consultaMapa(zona.getMapa().getId());
        zona.setRecinto(mapa);
        return zonaDao.altaZona(zona);
    }

    @Override
    public Zona bajaZona(Integer idZona) {
        return zonaDao.bajaZona(idZona);
    }

    @Override
    public Zona actualizaZona(Zona zona) {
        return zonaDao.actualizaZona(zona);
    }
    
    @Override
    public List<Zona> consultaZonasList(){
        return zonaDao.consultaZonasList();
        
    }
    
    @Override
    public Zona consultaZona(Integer id){
        return zonaDao.consultaZona(id);
    }

}

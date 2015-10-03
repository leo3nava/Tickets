package com.tickets.services.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.recintos.Asiento;
import com.tickets.api.entitys.catalogos.recintos.Zona;
import com.tickets.dao.catalogos.recintos.AsientoDao;
import com.tickets.dao.catalogos.recintos.ZonaDao;
import com.tickets.services.catalogos.recintos.AsientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AsientoServiceImpl implements AsientoService{

    @Autowired
    AsientoDao asientoDao;
    
    @Autowired
    ZonaDao zonaDao;
    
    @Override
    public Asiento altaAsiento(Asiento asiento) {
        
        Zona zona = zonaDao.consultaZona(asiento.getZona().getId());
        asiento.setZona(zona);
        return asientoDao.altaAsiento(asiento);
    }

    @Override
    public Asiento bajaAsiento(Integer idAsiento) {
        return asientoDao.bajaAsiento(idAsiento);
    }

    @Override
    public Asiento actualizaAsiento(Asiento asiento) {
        return asientoDao.actualizaAsiento(asiento);
    }
    
    @Override
    public List<Asiento> consultaAsientosList(){
        return asientoDao.consultaAsientosList();
        
    }
    
    @Override
    public Asiento consultaAsiento(Integer id){
        return asientoDao.consultaAsiento(id);
    }

}

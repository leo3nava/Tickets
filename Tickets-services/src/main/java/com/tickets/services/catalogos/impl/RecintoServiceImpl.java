package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.Recinto;
import com.tickets.dao.catalogos.RecintoDao;
import com.tickets.services.catalogos.RecintoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecintoServiceImpl implements RecintoService{

    @Autowired
    RecintoDao eventoFechasDao;
    
    @Override
    public Recinto altaRecinto(Recinto recinto) {
        return eventoFechasDao.altaRecinto(recinto);
    }

    @Override
    public Recinto bajaRecinto(Integer idRecinto) {
        return eventoFechasDao.bajaRecinto(idRecinto);
    }
    

    @Override
    public Recinto actualizaRecinto(Recinto recinto) {
        return eventoFechasDao.actualizaRecinto(recinto);
    }
    
    @Override
    public List<Recinto> consultaRecintoList(){
        return eventoFechasDao.consultaRecintoList();
        
    }
    
    @Override
    public Recinto consultaRecinto(Integer id){
        return eventoFechasDao.consultaRecinto(id);
    }

}

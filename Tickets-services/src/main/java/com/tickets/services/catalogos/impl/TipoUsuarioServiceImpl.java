package com.tickets.services.catalogos.impl;

import com.tickets.api.entitys.catalogos.TipoUsuario;
import com.tickets.dao.catalogos.TipoUsuarioDao;
import com.tickets.services.catalogos.TipoUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    @Autowired
    TipoUsuarioDao usuarioDao;
    
    @Override
    public TipoUsuario altaTipoUsuario(TipoUsuario usuario) {
        return usuarioDao.altaTipoUsuario(usuario);
    }

    @Override
    public TipoUsuario bajaTipoUsuario(Integer idTipoUsuario) {
        return usuarioDao.bajaTipoUsuario(idTipoUsuario);
    }

    @Override
    public TipoUsuario actualizaTipoUsuario(TipoUsuario usuario) {
        return usuarioDao.actualizaTipoUsuario(usuario);
    }
    
    @Override
    public List<TipoUsuario> consultaTipoUsuariosList(){
        return usuarioDao.consultaTipoUsuariosList();
        
    }
    
    @Override
    public TipoUsuario consultaTipoUsuario(Integer id){
        return usuarioDao.consultaTipoUsuario(id);
    }

}

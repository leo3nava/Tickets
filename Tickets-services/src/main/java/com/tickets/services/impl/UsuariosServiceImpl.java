package com.tickets.services.impl;

import com.tickets.api.entitys.catalogos.TipoUsuario;
import com.tickets.api.entitys.catalogos.Usuario;
import com.tickets.dao.InventarioDao;
import com.tickets.dao.UsuarioDao;
import com.tickets.dao.catalogos.TipoUsuarioDao;
import com.tickets.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuariosServiceImpl implements UsuarioService{

    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    TipoUsuarioDao tipoUsuarioDao;
    
    @Autowired
    InventarioDao inventarioDao;
    
    @Override
    public Usuario altaUsuario(Usuario usuario) {
        TipoUsuario tipoUsuario = tipoUsuarioDao.consultaTipoUsuario(usuario.getTipoUsuario().getId());
        usuario.setTipoUsuario(tipoUsuario);
        return usuarioDao.altaUsuario(usuario);
    }

    @Override
    public Usuario bajaUsuario(Long idUsuario) {
        return usuarioDao.bajaUsuario(idUsuario);
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) {
        return usuarioDao.actualizaUsuario(usuario);
    }
    
    @Override
    public List<Usuario> consultaUsuariosList(){
        return usuarioDao.consultaUsuariosList();
        
    }
    
    @Override
    public Usuario consultaUsuario(Long id){
        return usuarioDao.consultaUsuario(id);
    }

    public boolean loginUsuario(Usuario usuario) {
        System.out.println("Service loginUsuario usuario.getUserName(): " + usuario.getUserName() + ", usuario.getPassword(): " + usuario.getPassword());
        return usuarioDao.loginUsuario(usuario.getUserName(), usuario.getPassword());
    }

    public boolean validaUsuarioExistente(String nombreUsuario) {
        System.out.println("Service validaUsuarioExistente nombreUsuario: " + nombreUsuario);
        return usuarioDao.validaUsuarioExistente(nombreUsuario);
    }

}

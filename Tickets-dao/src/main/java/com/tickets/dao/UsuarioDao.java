package com.tickets.dao;

import com.tickets.api.entitys.catalogos.Usuario;
import java.util.List;

public interface UsuarioDao {
    
    public Usuario altaUsuario(Usuario usuario);
    
    public Usuario actualizaUsuario(Usuario usuario);
    
    public Usuario bajaUsuario(Long id);
    
    public List<Usuario> consultaUsuariosList();
    
    public Usuario consultaUsuario(Long id);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.services;

import com.tickets.api.entitys.catalogos.Usuario;
import com.tickets.services.*;
import java.util.List;



/**
 *
 * @author eduardo.chavez
 */
public interface UsuarioService {  
    
    public Usuario altaUsuario(Usuario usuario);
    
    public Usuario actualizaUsuario(Usuario usuario);
    
    public Usuario bajaUsuario(Long id);
    
    public List<Usuario> consultaUsuariosList();
    
    public Usuario consultaUsuario(Long id);
    
}

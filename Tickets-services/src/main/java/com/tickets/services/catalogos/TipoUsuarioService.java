package com.tickets.services.catalogos;

import com.tickets.api.entitys.catalogos.TipoUsuario;
import java.util.List;

public interface TipoUsuarioService {  
    
    public TipoUsuario altaTipoUsuario(TipoUsuario usuario);
    
    public TipoUsuario actualizaTipoUsuario(TipoUsuario usuario);
    
    public TipoUsuario bajaTipoUsuario(Integer id);
    
    public List<TipoUsuario> consultaTipoUsuariosList();
    
    public TipoUsuario consultaTipoUsuario(Integer id);
    
}

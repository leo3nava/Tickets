package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.TipoUsuario;
import com.tickets.services.catalogos.TipoUsuarioService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tipoUsuario") 
public class TipoUsuarioController {

    @Resource
    TipoUsuarioService usuarioService;
    
    @RequestMapping(value = "/altaTipoUsuario", method = RequestMethod.POST)
    public @ResponseBody TipoUsuario altaTipoUsuario(@RequestBody TipoUsuario usuario) {
        return usuarioService.altaTipoUsuario(usuario);
    }
    
    @RequestMapping(value = "/consultaTipoUsuario", method = RequestMethod.POST)
    public @ResponseBody List<TipoUsuario> consultaTipoUsuario() {
        return usuarioService.consultaTipoUsuariosList();
    }
    
    @RequestMapping(value = "/bajaTipoUsuario", method = RequestMethod.POST)
    public @ResponseBody boolean bajaTipoUsuario(@RequestBody Integer id) {
        usuarioService.bajaTipoUsuario(id);
        return true;
    }
}
package com.tickets.web.controllers.catalogos;

import com.tickets.api.entitys.catalogos.Usuario;
import com.tickets.services.UsuarioService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Resource
    UsuarioService usuarioService;
    Usuario u = new Usuario();
    @RequestMapping(value = "/altaUsuario", method = RequestMethod.POST)
    public @ResponseBody Usuario altaUsuario(@RequestBody Usuario usuario) {
        return usuarioService.altaUsuario(usuario);
    }
    
    @RequestMapping(value = "/consultaUsuarios", method = RequestMethod.POST)
    public @ResponseBody List<Usuario> consultaUsuarios() {
        return usuarioService.consultaUsuariosList();
    }
    
    @RequestMapping(value = "/bajaUsuario", method = RequestMethod.POST)
    public @ResponseBody boolean bajaUsuario(@RequestBody Long id) {
        usuarioService.bajaUsuario(id);
        return true;
    }
    
}
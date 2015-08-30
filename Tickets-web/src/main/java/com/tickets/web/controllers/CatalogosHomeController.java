package com.tickets.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogos")
public class CatalogosHomeController {
    
    @RequestMapping(value = "/usuarios")
    public String usuarios() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/usuarios";
    }
    
    @RequestMapping(value = "/usuariosModal")
    public String usuariosModal() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/usuariosModal";
    }
    
    @RequestMapping(value = "/tipoUsuario")
    public String tipoUsuario() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/tipoUsuario";
    }
    
    @RequestMapping(value = "/tipoUsuarioModal")
    public String tipoUsuarioModal() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/tipoUsuarioModal";
    }
    
}
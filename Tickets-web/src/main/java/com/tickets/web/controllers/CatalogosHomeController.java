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
    
    @RequestMapping(value = "/eventos")
    public String eventos() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/eventos";
    }
    
    @RequestMapping(value = "/eventosModal")
    public String eventosModal() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/modal/eventosModal";
    }
    
    @RequestMapping(value = "/eventoFechas")
    public String eventoFechas() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/eventoFechas";
    }
    
    @RequestMapping(value = "/eventoFechasModal")
    public String eventoFechasModal() {
        System.out.println("Se entra al Catalogo de Evento Fechasuarios Correctamente");
        return "catalogos/modal/eventoFechasModal";
    }
    
    @RequestMapping(value = "/recinto")
    public String recinto() {
        System.out.println("Se entra al Catalogo de recinto Correctamente");
        return "catalogos/recinto";
    }
    
    @RequestMapping(value = "/recintoModal")
    public String recintoModal() {
        System.out.println("Se entra al Catalogo de recinto Correctamente");
        return "catalogos/modal/recintoModal";
    }
}
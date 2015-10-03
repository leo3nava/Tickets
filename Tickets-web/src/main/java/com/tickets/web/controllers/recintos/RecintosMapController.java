package com.tickets.web.controllers.recintos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recintosMap")
public class RecintosMapController {

    @RequestMapping(value = "/mapas")
    public String mapas() {
        return "recintos/mapas";
    }

    @RequestMapping(value = "/mapasModal")
    public String mapasModal() {
        return "recintos/modal/mapasModal";
    }

    @RequestMapping(value = "/zonas")
    public String zonas() {
        return "recintos/zonas";
    }

    @RequestMapping(value = "/zonasModal")
    public String zonasModal() {
        return "recintos/modal/zonasModal";
    }
    
    @RequestMapping(value = "/asientos")
    public String asientos() {
        return "recintos/asientos";
    }

    @RequestMapping(value = "/asientosModal")
    public String asientosModal() {
        return "recintos/modal/asientosModal";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.web.controllers;

import com.tickets.services.UsuarioService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author eduardo.chavez
 */
@Controller
@RequestMapping("/catalogos")
public class CatalogosHomeController {
    //@Resource
    //UsuarioService usuarioService;
    
    @RequestMapping(value = "/usuarios")
    public String usuarios() {
        System.out.println("Se entra al Catalogo de Usuarios Correctamente");
        return "catalogos/usuarios";
    }
    
    @RequestMapping(value = "/producto")
    public String producto() {
        System.out.println("Se entra al Home Controller Correctamente: portal");
        return "catalogos/producto";
    }
    
    @RequestMapping(value = "/administracion")
    public String administracion() {
        System.out.println("Se entra al Home Controller Correctamente: administracion");
        return "administracion";
    }
    
    @RequestMapping(value = "/punto_venta")
    public String puntoVenta() {
        System.out.println("Se entra al Home Controller Correctamente: punto_venta");
        return "punto_venta";
    } 
    /*
    @RequestMapping(value = "/loginusuario", method = RequestMethod.POST)
    public @ResponseBody UsuarioEntity loginUsuario(@RequestBody UsuarioEntity usuarioEntity){
        usuarioService.loginUsuario(usuarioEntity);
        usuarioEntity.setError(true);
        return usuarioEntity;
    }
    
    @RequestMapping(value="/registrausuario", method = RequestMethod.POST)
    public @ResponseBody UsuarioEntity registraUsuario(@RequestBody UsuarioEntity usuarioEntity){
        usuarioService.registraUsuario(usuarioEntity);
        return usuarioEntity;
    }*/
}
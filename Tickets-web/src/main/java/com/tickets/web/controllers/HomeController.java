/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eduardo.chavez
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    //@Resource
    //UsuarioService usuarioService;
    
    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("Se entra al Home Controller Correctamente");
        return "index";
    }
    
    @RequestMapping(value = "/home")
    public String home() {
        System.out.println("Se entra al Home Controller Correctamente");
        return "home";
    }
    
    @RequestMapping(value = "/portal")
    public String portal() {
        System.out.println("Se entra al Home Controller Correctamente: portal");
        return "portal";
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
    @RequestMapping(value = "/usuarios")
    public String usuarios() {
        System.out.println("Se entra al Home Controller Correctamente: usuarios");
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
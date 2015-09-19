package com.tickets.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    String className = "HomeController";
    
    @RequestMapping(value = "/")
    public String portal1() {
        String methodName = className + " | portal():: ";
        System.out.println(methodName);
        return "portal/index";
    }
    
    @RequestMapping(value = "home")
    public String home() {
        String methodName = className + " | home():: ";
        System.out.println(methodName);
        return "home";
    }
    
    @RequestMapping(value = "portal")
    public String portal() {
        String methodName = className + " | portal():: ";
        System.out.println(methodName);
        return "portal/index";
    }
    
    @RequestMapping(value = "menu")
    public String menu() {
        String methodName = className + " | menu():: ";
        System.out.println(methodName);
        return "portal/menu";
    }
    
    @RequestMapping(value = "principal")
    public String principal() {
        String methodName = className + " | principal():: ";
        System.out.println(methodName);
        return "portal/principal";
    }
    
    @RequestMapping(value = "slider")
    public String slider(){
        String methodName = className + " | slider():: ";
        System.out.println(methodName);
        return "portal/principal/slider";
    }
    
    @RequestMapping(value = "contenido")
    public String contenido(){
        String methodName = className + " | contenido():: ";
        System.out.println(methodName);
        return "portal/principal/contenido";
    }
    
    @RequestMapping(value = "eventos")
    public String eventos(){
        String methodName = className + " | eventos():: ";
        System.out.println(methodName);
        return "portal/eventos";
    }
    
    
    @RequestMapping(value = "evento1")
    public String evento1(){
        String methodName = className + " | evento1():: ";
        System.out.println(methodName);
        return "portal/eventos/evento1";
    }
    
//    
//    @RequestMapping(value = "portal")
//    public String portal() {
//        String methodName = className + " | portal():: ";
//        System.out.println(methodName);
//        return "portal";
//    }
    
    @RequestMapping(value = "administracion")
    public String administracion() {
        System.out.println("Se entra al Home Controller Correctamente: administracion");
        return "administracion";
    }   
}
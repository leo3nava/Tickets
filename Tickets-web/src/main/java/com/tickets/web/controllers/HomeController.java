package com.tickets.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    String className = "HomeController";
    String methodName = "";
    
//    @RequestMapping(value = "/")
//    public String index() {
//        methodName = className + " | index():: ";
//        System.out.println(methodName);
//        return "index";
//    }
    
    @RequestMapping(value = "home")
    public String home() {
        methodName = className + " | home():: ";
        System.out.println(methodName);
        return "home";
    }
    
    @RequestMapping(value = "")
    public String portal1() {
        methodName = className + " | portal():: ";
        System.out.println(methodName);
        return "portal/index";
    }
    
    @RequestMapping(value = "portal")
    public String portal() {
        methodName = className + " | portal():: ";
        System.out.println(methodName);
        return "portal/index";
    }
    
    @RequestMapping(value = "menu")
    public String menu() {
        methodName = className + " | menu():: ";
        System.out.println(methodName);
        return "portal/menu";
    }
    
    @RequestMapping(value = "contenido")
    public String contenido() {
        methodName = className + " | contenido():: ";
        System.out.println(methodName);
        return "portal/contenido";
    }
    
    
    
    
    
    
    
//    
//    @RequestMapping(value = "portal")
//    public String portal() {
//        methodName = className + " | portal():: ";
//        System.out.println(methodName);
//        return "portal";
//    }
    
    @RequestMapping(value = "administracion")
    public String administracion() {
        System.out.println("Se entra al Home Controller Correctamente: administracion");
        return "administracion";
    }   
}
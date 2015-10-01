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
 * @author Eduardosco
 */

@Controller
@RequestMapping("admin")
public class AdminController {
    String className = "AdminController";
    
    @RequestMapping(value = "")
    public String admin() {
        String methodName = className + " | admin():: ";
        System.out.println(methodName);
        return "admin/index";
    }
    @RequestMapping(value = "menu")
    public String menu() {
        String methodName = className + " | menu():: ";
        System.out.println(methodName);
        return "admin/menu";
    }
    @RequestMapping(value = "contenido")
    public String contenido() {
        String methodName = className + " | contenido():: ";
        System.out.println(methodName);
        return "admin/contenido";
    }
}

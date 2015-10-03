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
@RequestMapping("login")
public class LoginController {
    String className = "LoginController";
    
    @RequestMapping(value = "")
    public String login() {
        String methodName = className + " | login():: ";
        System.out.println(methodName);
        return "login/index";
    }
}

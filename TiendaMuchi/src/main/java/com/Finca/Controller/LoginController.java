/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Campos
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("/Login")
    public String Inicio() {
        return "/Login/inicio";
    }

    @GetMapping("/Login/CrearCuenta")
    public String CrearCuenta() {
        return "/Login/CrearCuenta";
    }

    @GetMapping("/Login/IniciarSesion")
    public String IniciarSesion() {
        return "/Login/IniciarSesion";
    }
}

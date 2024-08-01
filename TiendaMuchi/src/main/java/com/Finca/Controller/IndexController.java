/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import com.Finca.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Campos
 */
@Controller
public class IndexController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/index")
    public String contactoPage(Model model) {
        var categorias= categoriaService.getCategorias(false);
        var totalcategorias= categorias.size();
        System.out.println(categorias);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalcategorias", totalcategorias);
        return "index";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import com.Finca.Domain.Categoria;
import com.Finca.Service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

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
        List<Categoria> categorias = categoriaService.findAllWithSubcategorias();
        var totalcategorias = categorias.size();
        model.addAttribute("totalcategorias", totalcategorias);
        model.addAttribute("categorias", categorias);
        return "index";
    }

    @GetMapping("/")
    public RedirectView redirectToIndex() {
        return new RedirectView("/index");
    }
}

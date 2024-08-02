/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import com.Finca.Domain.Subcategoria;
import com.Finca.Service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Campos
 */
@RestController
public class RestControllers {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/obtenerSubcategoria")
    public List<Subcategoria> getSubcategorias(@RequestParam("categoriaId") Long categoriaId) {
        return categoriaService.findSubcategoriasByCategoriaId(categoriaId);
    }
}

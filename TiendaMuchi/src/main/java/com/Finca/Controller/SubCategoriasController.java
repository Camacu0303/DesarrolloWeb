/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

/**
 *
 * @author Campos
 */
import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import com.Finca.Service.CategoriaService;
import com.Finca.Service.FirebaseStorageService;
import com.Finca.Service.SubCategoriaService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Campos
 */
@Controller
@Slf4j
public class SubCategoriasController {

    @Autowired
    private SubCategoriaService SubcategoriaService;  
    
    @Autowired
    private CategoriaService categoriaService;  
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/SubCategorias")
    public String inicio(Model model) {
        var SubCategoria = SubcategoriaService.getSubCategorias(false);
        var categorias= categoriaService.getCategorias(false);
        model.addAttribute("Categorias", categorias);
        model.addAttribute("SubCategorias", SubCategoria);
        model.addAttribute("SubCategoria", new Subcategoria());
        model.addAttribute("totalSubCategorias", SubCategoria.size());
        return "/SubCategorias/listado";
    }
    
    @PostMapping("/SubCategorias/Guardar")
    public String categoriaGuardar(Subcategoria subcategoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
        SubcategoriaService.save(subcategoria);
        subcategoria.setRutaImagen(
        firebaseStorageService.cargaImagen(
        imagenFile,
        "subcategoria",
        subcategoria.getIdSubcategoria()));
        }
        
        SubcategoriaService.save(subcategoria); 
        return "redirect:/SubCategorias";
    }

    @GetMapping("/SubCategorias/eliminar/{idSubcategoria}")
    public String categoriaEliminar(Subcategoria subcategoria) {
        SubcategoriaService.delete(subcategoria);
        return "redirect:/SubCategorias";
    }

    @GetMapping("/SubCategorias/modificar/{idSubcategoria}")
    public String categoriaModificar(Subcategoria subcategoria, Model model) {
        subcategoria = SubcategoriaService.getSubCategoria(subcategoria);
        model.addAttribute("SubCategoria", subcategoria);
        return "/SubCategorias/modifica";
    }
}

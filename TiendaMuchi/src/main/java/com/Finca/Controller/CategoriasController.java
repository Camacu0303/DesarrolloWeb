
package com.Finca.Controller;

import com.Finca.Domain.Categoria;
import com.Finca.Service.CategoriaService;
import com.Finca.Service.FirebaseStorageService;
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


@Controller
@Slf4j
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/Categorias")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("totalCategorias", categorias.size());
        return "/Categorias/listado";
    }

    @PostMapping("/Categorias/Guardar")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            categoria.getIdCategoria()));
        }

        categoriaService.save(categoria); 
        return "redirect:/Categorias";
    }

    @GetMapping("/Categorias/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/Categorias";
    }

    @GetMapping("/Categorias/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/Categorias/modifica";
    }
}

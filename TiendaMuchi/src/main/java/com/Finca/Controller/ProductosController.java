/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import com.Finca.Service.CategoriaService;
import com.Finca.Service.FirebaseStorageService;
import com.Finca.Service.ProductoService;
import com.Finca.Service.SubCategoriaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Campos
 */
@Controller
@Slf4j
public class ProductosController {
    @GetMapping("/Productos")
    public String Inicio(Model model) {
        model.addAttribute("Subcategorias", SubcategoriaService.getSubCategorias(false));
        model.addAttribute("Categorias", CategoriaService.getCategorias(false));   
        model.addAttribute("Producto", new Producto());
        model.addAttribute("Productos", productoService.getProductos(false));
        model.addAttribute("totalproductos", productoService.getProductos(false).size());
        return "/Productos/listado"; 
    }
    
    @Autowired
    private SubCategoriaService SubcategoriaService;
    
    @Autowired
    private CategoriaService CategoriaService;

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping
    ("/Productos/Guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Producto",
                            producto.getIdProducto()));
        }

        productoService.save(producto);
        producto.getSubcategoria().addProducto(producto);
        SubcategoriaService.save(producto.getSubcategoria());
        return "redirect:/Productos";
    }

    @GetMapping("/Productos/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/Productos";
    }

    @GetMapping("/Productos/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("Producto", producto);
        return "/Productos/modifica";
    }
    @GetMapping("/Productos/listadoIndividual/{idProducto}")
    public String listadoIndividual(Producto producto, Model model) {
        var SubCategoria = productoService.getProducto(producto);
        model.addAttribute("Producto", SubCategoria);
        return "/Productos/listadoIndividual";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Controller;

import com.Finca.Domain.Usuario;
import com.Finca.Service.FirebaseStorageService;
import com.Finca.Service.UsuarioService;
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
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/Usuarios")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/Usuarios/listado";
    }

    @PostMapping("/Usuarios/Guardar")
    public String categoriaGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getId()));
        }

        usuarioService.save(usuario);
        return "redirect:/Usuarios";
    }

    @GetMapping("/Usuarios/eliminar/{id}")
    public String categoriaEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/Usuarios";
    }

    @GetMapping("/Usuarios/modificar/{id}")
    public String categoriaModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/Usuarios/modifica";

    }
}

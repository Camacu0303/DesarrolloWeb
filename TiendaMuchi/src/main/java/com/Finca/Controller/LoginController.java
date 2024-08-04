
package com.Finca.Controller;

import com.Finca.Domain.Usuario;
import com.Finca.Service.FirebaseStorageService;
import com.Finca.Service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

        
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
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

    @PostMapping("/Login/Guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuario.setRole("cliente");
        usuario.setActivo(true);
        usuarioService.save(usuario);
        if(usuarioService.getUsuario(usuario)!=null){
                return "redirect:/index";
        }else{
            return "redirect:/Login";
        }
    }
}

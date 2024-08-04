/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Finca.Service;

import com.Finca.Domain.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Campos
 */
@Service
public interface UsuarioService {
    List<Usuario> getUsuarios(boolean activos);
    Usuario getUsuario(Usuario usuario);
    void save(Usuario usuario);
    public void delete(Usuario usuario);
}

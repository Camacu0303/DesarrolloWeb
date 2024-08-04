
package com.Finca.Service;

import com.Finca.Domain.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface UsuarioService {
    List<Usuario> getUsuarios(boolean activos);
    Usuario getUsuario(Usuario usuario);
    void save(Usuario usuario);
    public void delete(Usuario usuario);
}

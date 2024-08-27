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

    public List<Usuario> getUsuarios();
// Se obtiene un Usuario, a part ir del id de un usuario

   // public Usuario getUsuario(Usuario usuario);
// Se obtiene un Usuario, a part ir del username de un usuario

    public Usuario getUsuarioPorUsername(String username);
    // Se obtiene un Usuario a partir del username y el password de un usuario


}

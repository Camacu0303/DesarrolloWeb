
package com.Finca.ServiceImpl;

import com.Finca.Dao.UsuarioDAO;
import com.Finca.Domain.Usuario;
import com.Finca.Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDao;

    @Override
    public List<Usuario> getUsuarios(boolean activos) {
        var lista = usuarioDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
         return usuarioDao.findById(usuario.getId()).orElse(null);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

}


package com.Finca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Finca.Domain.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>  {
}

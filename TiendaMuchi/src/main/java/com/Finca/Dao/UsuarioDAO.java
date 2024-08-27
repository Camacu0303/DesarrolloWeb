
package com.Finca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Finca.Domain.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>  {
 
    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrMail(String username, String mail);

    boolean existsByUsernameOrMail(String username, String mail);


}

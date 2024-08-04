    
package com.Finca.Dao;


import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubCategoriasDAO extends JpaRepository<Subcategoria, Long>{
    List<Subcategoria> findByCategoria(Categoria categoria);
}
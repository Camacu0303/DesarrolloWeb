
package com.Finca.Dao;

import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CategoriasDAO extends JpaRepository<Categoria, Long> {

    @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.subcategorias")
    List<Categoria> findAllWithSubcategorias();
    
    @Query("SELECT s FROM Subcategoria s WHERE s.categoria.id = :categoriaId")
    public List<Subcategoria> findSubcategoriasByCategoriaId(Long categoriaId);
}

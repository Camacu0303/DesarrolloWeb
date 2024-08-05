package com.Finca.Dao;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosDAO extends JpaRepository<Producto, Long> {

    List<Producto> findBySubcategoria(Subcategoria subcategoria);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}

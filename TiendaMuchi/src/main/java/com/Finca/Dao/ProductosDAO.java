/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Dao;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Campos
 */
public interface ProductosDAO extends JpaRepository<Producto, Long> {

    List<Producto> findBySubcategoria(Subcategoria subcategoria);
}

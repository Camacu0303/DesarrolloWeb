/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Finca.Service;

import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Campos
 */
public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);


    public Categoria getCategoria(Categoria categoria);


  
    public void save(Categoria categoria);

  
    public void delete(Categoria categoria);

    public List<Categoria> getAllCategoriasWithSubcategorias();

    public void addSubcategoriaToCategoria(Long categoriaId, Subcategoria subcategoria);

    public List<Categoria> findAll();

    public List<Categoria> findAllWithSubcategorias();

    public List<Subcategoria> findSubcategoriasByCategoriaId(Long categoriaId);
    
}

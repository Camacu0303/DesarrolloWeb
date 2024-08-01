/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Service;

import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import java.util.List;

/**
 *
 * @author Campos
 */
public interface SubCategoriaService {
    List<Subcategoria> getSubCategorias(boolean activos);
    Subcategoria getSubCategoria(Subcategoria categoria);
    void save(Subcategoria categoria);
    List<Subcategoria> getSubCategoriasByCategoria(Categoria categoria);
    public void delete(Subcategoria categoria);
}

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
    public List<Subcategoria> getSubCategorias(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Subcategoria getSubCategoria(Subcategoria subcategoria);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Subcategoria subcategoria);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Subcategoria subcategoria);
}

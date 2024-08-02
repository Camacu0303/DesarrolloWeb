/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Service;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import java.util.List;

/**
 *
 * @author Campos
 */
public interface ProductoService {
    List<Producto> getProductos(boolean activos);
    Producto getProducto(Producto producto);
    void save(Producto producto);
    public List<Producto> getProductoBySubCategoria(Subcategoria subcategoria);
    public void delete(Producto producto);
}

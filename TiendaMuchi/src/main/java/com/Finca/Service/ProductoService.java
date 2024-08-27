
package com.Finca.Service;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import java.util.List;


public interface ProductoService {
    List<Producto> getProductos(boolean activos);
    Producto getProducto(Producto producto);
    Producto getProductoById(Long idProducto); // Nuevo método para obtener por ID
    void save(Producto producto);
    List<Producto> getProductoBySubCategoria(Subcategoria subcategoria);
    void delete(Producto producto);
    List<Producto> searchByName(String nombre);
}

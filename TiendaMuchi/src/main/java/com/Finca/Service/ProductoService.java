
package com.Finca.Service;

import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import java.util.List;


public interface ProductoService {
    List<Producto> getProductos(boolean activos);
    Producto getProducto(Producto producto);
    void save(Producto producto);
    public List<Producto> getProductoBySubCategoria(Subcategoria subcategoria);
    public void delete(Producto producto);
}

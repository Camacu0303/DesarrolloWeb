
package com.Finca.ServiceImpl;

import com.Finca.Dao.ProductosDAO;
import com.Finca.Dao.SubCategoriasDAO;
import com.Finca.Domain.Producto;
import com.Finca.Domain.Subcategoria;
import com.Finca.Service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductosDAO productosDAO;
    
    @Autowired
    private SubCategoriasDAO categoriaDao;
    
    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = productosDAO.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productosDAO.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
       productosDAO.save(producto);
    }

    @Override
    public List<Producto> getProductoBySubCategoria(Subcategoria subcategoria) {
        return productosDAO.findBySubcategoria(subcategoria);
    }

    @Override
    public void delete(Producto producto) {
        productosDAO.delete(producto);
    }


}

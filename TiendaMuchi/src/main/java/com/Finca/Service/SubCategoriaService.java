
package com.Finca.Service;

import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import java.util.List;


public interface SubCategoriaService {
    List<Subcategoria> getSubCategorias(boolean activos);
    Subcategoria getSubCategoria(Subcategoria categoria);
    void save(Subcategoria categoria);
    List<Subcategoria> getSubCategoriasByCategoria(Categoria categoria);
    public void delete(Subcategoria categoria);
}

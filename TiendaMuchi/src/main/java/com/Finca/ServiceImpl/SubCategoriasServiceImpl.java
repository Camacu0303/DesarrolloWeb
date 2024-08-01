/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.ServiceImpl;

import com.Finca.Dao.SubCategoriasDAO;
import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import com.Finca.Service.SubCategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Campos
 */
@Service 
public class SubCategoriasServiceImpl implements SubCategoriaService{

    @Autowired
    private SubCategoriasDAO categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Subcategoria> getSubCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Subcategoria getSubCategoria(Subcategoria categoria) {
        return categoriaDao.findById(categoria.getIdSubcategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Subcategoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Subcategoria categoria) {
        categoriaDao.delete(categoria);
    }
}

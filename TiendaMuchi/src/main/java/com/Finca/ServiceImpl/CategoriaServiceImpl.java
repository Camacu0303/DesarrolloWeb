/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.ServiceImpl;

import com.Finca.Dao.CategoriasDAO;
import com.Finca.Domain.Categoria;
import com.Finca.Domain.Subcategoria;
import com.Finca.Service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Campos
 */
@Service //Implementa logica de lista de categorias
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired //
    private CategoriasDAO categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional
    public List<Categoria> findAllWithSubcategorias() {
        return categoriaDao.findAllWithSubcategorias();
    }

    @Transactional
    public void addSubcategoriaToCategoria(Long categoriaId, Subcategoria subcategoria) {
        Categoria categoria = categoriaDao.findById(categoriaId).orElseThrow(() -> new RuntimeException("Categoria not found"));
        subcategoria.setCategoria(categoria);
        categoria.getSubcategorias().add(subcategoria);
        categoriaDao.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }

    @Override
    public List<Categoria> getAllCategoriasWithSubcategorias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Subcategoria> findSubcategoriasByCategoriaId(Long categoriaId) {
        return categoriaDao.findSubcategoriasByCategoriaId(categoriaId);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Finca.Dao;

import com.Finca.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Campos
 */
public interface CategoriasDAO extends JpaRepository<Categoria, Long>{
    
}

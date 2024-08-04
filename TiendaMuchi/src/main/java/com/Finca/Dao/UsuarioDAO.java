/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Finca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Finca.Domain.Usuario;
/**
 *
 * @author Campos
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Long>  {
}

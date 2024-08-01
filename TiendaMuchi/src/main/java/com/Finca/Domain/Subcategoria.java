
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Long idSubcategoria;

    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL)
    private Set<Producto> productos;

    public Subcategoria() {
    }

    public Subcategoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
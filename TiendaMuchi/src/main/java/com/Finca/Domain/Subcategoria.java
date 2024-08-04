
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Finca.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    private String nombre;

    @Column(name = "ruta_imagen", length = 2048)
    private String rutaImagen;
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL)
    private Set<Producto> productos;

    public Subcategoria() {
    }

    public Subcategoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Child{id=" + idSubcategoria + ", parentId=" + (categoria != null ? categoria.getIdCategoria() : null) + "}";
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
        producto.setSubcategoria(this);
    }

    public void removeProducto(Subcategoria subcategoria) {
        productos.remove(subcategoria);
    }
}

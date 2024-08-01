package com.Finca.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nombre;
    private String descripcion;
    
    @Column(name = "ruta_imagen", length = 2048)
    private String rutaImagen;
    
    private boolean activo;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<Subcategoria> subcategorias;

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion, boolean activo) {
        this.nombre= nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
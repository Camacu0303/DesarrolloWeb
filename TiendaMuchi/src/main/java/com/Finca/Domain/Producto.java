package com.Finca.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;
    private int existencias;
    private double precio;
    private String descripcion;

    @Column(name = "ruta_imagen", length = 2048)
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_subcategoria")
    private Subcategoria subcategoria;

    @Override
    public String toString() {
        return "Child{id=" + idProducto + ", parentId=" + (subcategoria != null ? subcategoria.getIdSubcategoria() : null) + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producto that = (Producto) o;
        return Objects.equals(idProducto, that.idProducto);
    }

    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}

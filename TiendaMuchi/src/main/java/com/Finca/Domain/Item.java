package com.Finca.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Item extends Producto {

    private int cantidad; // Almacenar la cantidad de ítems de un producto

    public Item() {
    }

    public Item(Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setNombre(producto.getNombre());
        super.setExistencias(producto.getExistencias());
        super.setPrecio(producto.getPrecio());
        super.setDescripcion(producto.getDescripcion());
        super.setRutaImagen(producto.getRutaImagen());
        super.setActivo(producto.isActivo());
        super.setSubcategoria(producto.getSubcategoria());
        this.cantidad = 0;
    }
}
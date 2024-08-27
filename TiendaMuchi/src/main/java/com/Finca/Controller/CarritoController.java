package com.Finca.Controller;

import com.Finca.Domain.Item;
import com.Finca.Domain.Producto;
import com.Finca.Service.ItemService;
import com.Finca.Service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductoService productoService;

       @GetMapping("/")
    private String listado(Model model) {
        List<Producto> productos = productoService.getProductos(true); // Mostrar solo productos activos
        model.addAttribute("productos", productos);
        return "/index";
    }
    
    
    //Para ver el carrito

      @GetMapping("/carrito/listado")
    public String verCarrito(Model model) {
        List<Item> items = itemService.gets();
        model.addAttribute("items", items);
        double carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }
    
    
//Para Agregar un producto al carrito
@GetMapping("/carrito/agregar/{idProducto}")
public ModelAndView agregarItem(@PathVariable("idProducto") Long idProducto, Model model) {
    System.out.println("ID Producto recibido: " + idProducto); // Depuración

    Producto producto = productoService.getProductoById(idProducto);
    if (producto == null) {
        model.addAttribute("error", "Producto no encontrado.");
        return new ModelAndView("error");
    }

    Item item = new Item(producto);
    itemService.save(item);

    List<Item> lista = itemService.gets();
    int totalCarritos = 0;
    double carritoTotalVenta = 0.0;

    for (Item i : lista) {
        totalCarritos += i.getCantidad();
        carritoTotalVenta += (i.getCantidad() * i.getPrecio());
    }

    model.addAttribute("listaItems", lista);
    model.addAttribute("listaTotal", totalCarritos);
    model.addAttribute("carritoTotal", carritoTotalVenta);

    return new ModelAndView("/carrito/fragmentos :: verCarrito");
}


   

    // Para actualizar un producto del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(@ModelAttribute Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    // Para facturar los productos del carrito
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar(); // Implementar la lógica de facturación
        return "redirect:/";
    }

}

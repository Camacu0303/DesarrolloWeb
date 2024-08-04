
package com.Finca.Controller;

import com.Finca.Domain.Categoria;
import com.Finca.Service.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class IndexController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/index")
    public String contactoPage(Model model) {
        List<Categoria> categorias = categoriaService.findAllWithSubcategorias();
        var totalcategorias = categorias.size();
        model.addAttribute("totalcategorias", totalcategorias);
        model.addAttribute("categorias", categorias);
        return "index";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("message", "Ocurrió un error. Por favor, vuelve a intentarlo.");
        model.addAttribute("referer", referer);
        return "error";
    }

    @GetMapping("/")
    public String inicio(Model model) { 
        return "index";
    }
}

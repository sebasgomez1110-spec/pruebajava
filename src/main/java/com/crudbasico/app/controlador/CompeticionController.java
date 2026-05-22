package com.crudbasico.app.controlador;

import com.crudbasico.app.model.Competicion;
import com.crudbasico.app.repository.CompeticionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    private final CompeticionRepository repository;

    public CompeticionController(CompeticionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "competicion/index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        repository.save(competicion);
        return "redirect:/competiciones/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("competiciones", repository.findAll());
        return "competicion/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("competicion", repository.findById(id).orElse(new Competicion()));
        return "competicion/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/competiciones/listar";
    }
}
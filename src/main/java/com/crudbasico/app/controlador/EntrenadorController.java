package com.crudbasico.app.controlador;

import com.crudbasico.app.model.Entrenador;
import com.crudbasico.app.repository.EntrenadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private final EntrenadorRepository repository;

    public EntrenadorController(EntrenadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "entrenador/index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        repository.save(entrenador);
        return "redirect:/entrenadores/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("entrenadores", repository.findAll());
        return "entrenador/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", repository.findById(id).orElse(new Entrenador()));
        return "entrenador/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/entrenadores/listar";
    }
}
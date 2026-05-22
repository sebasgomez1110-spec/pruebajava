package com.crudbasico.app.controlador;

import com.crudbasico.app.model.Asociacion;
import com.crudbasico.app.repository.AsociacionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    private final AsociacionRepository repository;

    public AsociacionController(AsociacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "asociacion/index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        repository.save(asociacion);
        return "redirect:/asociaciones/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("asociaciones", repository.findAll());
        return "asociacion/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("asociacion", repository.findById(id).orElse(new Asociacion()));
        return "asociacion/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/asociaciones/listar";
    }
}
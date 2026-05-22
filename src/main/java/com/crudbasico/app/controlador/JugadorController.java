package com.crudbasico.app.controlador;

import com.crudbasico.app.model.Jugador;
import com.crudbasico.app.repository.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorRepository repository;

    public JugadorController(JugadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "jugador/index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        repository.save(jugador);
        return "redirect:/jugadores/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("jugadores", repository.findAll());
        return "jugador/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", repository.findById(id).orElse(new Jugador()));
        return "jugador/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/jugadores/listar";
    }
}
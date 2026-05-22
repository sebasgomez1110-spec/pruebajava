package com.crudbasico.app.controlador;

import com.crudbasico.app.model.Club;
import com.crudbasico.app.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    private final ClubRepository clubRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final JugadorRepository jugadorRepository;
    private final AsociacionRepository asociacionRepository;
    private final CompeticionRepository competicionRepository;

    public ClubController(
            ClubRepository clubRepository,
            EntrenadorRepository entrenadorRepository,
            JugadorRepository jugadorRepository,
            AsociacionRepository asociacionRepository,
            CompeticionRepository competicionRepository
    ) {
        this.clubRepository = clubRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.jugadorRepository = jugadorRepository;
        this.asociacionRepository = asociacionRepository;
        this.competicionRepository = competicionRepository;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("club", new Club());
        cargarDatos(model);
        return "club/index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/clubes/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "club/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("club", clubRepository.findById(id).orElse(new Club()));
        cargarDatos(model);
        return "club/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clubRepository.deleteById(id);
        return "redirect:/clubes/listar";
    }

    private void cargarDatos(Model model) {
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
    }
}
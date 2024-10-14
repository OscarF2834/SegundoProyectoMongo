package com.example.mongo.oscar.Controller;

import com.example.mongo.oscar.Exception.NotFoundException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.mongo.oscar.Entity.Equipo;
import com.example.mongo.oscar.Entity.Asociacion;
import com.example.mongo.oscar.Entity.Competicion;
import com.example.mongo.oscar.Entity.Director;
import com.example.mongo.oscar.Entity.Jugador;
import com.example.mongo.oscar.Repository.*;

@Controller
@RequestMapping(value = "/equipos")
public class EquipoWebController {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private CompeticionRepository competicionRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        return "equipos-list";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        model.addAttribute("directores", directorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "equipos-form";
    }

    @GetMapping("/{id}")
    public String equipoDetailTemplate(@PathVariable String id, Model model) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
        model.addAttribute("equipo", equipo);
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        model.addAttribute("directores", directorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "equipos-form";
    }

    @PostMapping("/save")
    public String saveEquipo(Equipo equipo, @RequestParam String asociacionId,
                             @RequestParam List<String> competicionId, @RequestParam String directorId,
                             @RequestParam List<String> jugadorId) {
        Asociacion asociacion = asociacionRepository.findById(asociacionId)
                .orElseThrow(() -> new NotFoundException("Asociación no encontrada"));
        List<Competicion> competicion = competicionRepository.findAllById(competicionId);
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NotFoundException("Director no encontrado"));
        List<Jugador> jugador = jugadorRepository.findAllById(jugadorId);

        equipo.setAsociacion(asociacion);
        equipo.setCompeticion(competicion);
        equipo.setDirector(director);
        equipo.setJugador(jugador);

        equipoRepository.save(equipo);
        return "redirect:/equipos/";
    }


    @GetMapping("/edit/{id}")
    public String editEquipo(@PathVariable String id, Model model) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
        model.addAttribute("equipo", equipo);
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        model.addAttribute("directores", directorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "equipos-form";
    }

    @PostMapping("/update")
    public String updateEquipo(Equipo equipo, @RequestParam String asociacionId,
                               @RequestParam List<String> competicionId, @RequestParam String directorId,
                               @RequestParam List<String> jugadorId) {
        Asociacion asociacion = asociacionRepository.findById(asociacionId)
                .orElseThrow(() -> new NotFoundException("Asociación no encontrada"));
        List<Competicion> competicion = competicionRepository.findAllById(competicionId);
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NotFoundException("Director no encontrado"));
        List<Jugador> jugador = jugadorRepository.findAllById(jugadorId);

        equipo.setAsociacion(asociacion);
        equipo.setCompeticion(competicion);
        equipo.setDirector(director);
        equipo.setJugador(jugador);

        equipoRepository.save(equipo);
        return "redirect:/equipos/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipo(@PathVariable String id) {
        equipoRepository.deleteById(id);
        return "redirect:/equipos/";
    }
}
package com.example.mongo.oscar.Controller;

import com.example.mongo.oscar.Entity.*;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipos")
public class EquipoRestController {

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
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable String id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Equipo saveEquipo(@RequestBody Equipo equipo,
                             @RequestParam String asociacionId,
                             @RequestParam List<String> competicionId,
                             @RequestParam String directorId,
                             @RequestParam List<String> jugadorId) {
        // Asignar asociación, competiciones, director y jugadores
        Asociacion asociacion = asociacionRepository.findById(asociacionId)
                .orElseThrow(() -> new NotFoundException("Asociación no encontrada"));
        equipo.setAsociacion(asociacion);

        List<Competicion> competiciones = competicionRepository.findAllById(competicionId);
        equipo.setCompeticion(competiciones);

        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NotFoundException("Director no encontrado"));
        equipo.setDirector(director);

        List<Jugador> jugadores = jugadorRepository.findAllById(jugadorId);
        equipo.setJugador(jugadores);

        return equipoRepository.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable String id,
                               @RequestBody Equipo equipo,
                               @RequestParam String asociacionId,
                               @RequestParam List<String> competicionId,
                               @RequestParam String directorId,
                               @RequestParam List<String> jugadorId) {
        Equipo equipoExistente = equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));

        Asociacion asociacion = asociacionRepository.findById(asociacionId)
                .orElseThrow(() -> new NotFoundException("Asociación no encontrada"));
        equipoExistente.setAsociacion(asociacion);

        List<Competicion> competiciones = competicionRepository.findAllById(competicionId);
        equipoExistente.setCompeticion(competiciones);

        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NotFoundException("Director no encontrado"));
        equipoExistente.setDirector(director);

        List<Jugador> jugadores = jugadorRepository.findAllById(jugadorId);
        equipoExistente.setJugador(jugadores);

        equipoExistente.setNombre(equipo.getNombre());

        return equipoRepository.save(equipoExistente);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable String id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
        equipoRepository.delete(equipo);
    }
}

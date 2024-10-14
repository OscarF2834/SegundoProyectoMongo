package com.example.mongo.oscar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongo.oscar.Entity.Jugador;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.JugadorRepository;
@Controller
@RequestMapping(value = "jugadores")

public class JugadorWebController {
	@Autowired
    private JugadorRepository jugadorRepository;
	
	  @GetMapping("/")
	    public String jugadoresListTemplate(Model model) {
	        model.addAttribute("jugadores", jugadorRepository.findAll());
	        return "jugadores-list";
	    }

	    @GetMapping("/new")
	    public String jugadoresNewTemplate(Model model) {
	        model.addAttribute("jugador", new Jugador());
	        return "jugadores-form";
	    }

	    @GetMapping("/edit/{id}")
	    public String jugadorEditTemplate(@PathVariable("id") String id, Model model) {
	        model.addAttribute("jugador", jugadorRepository.findById(id).orElseThrow(() -> new NotFoundException("Jugador no encontrado")));
	        return "jugadores-form";
	    }

	    @PostMapping("/save")
	    public String jugadoresSaveProcess(@ModelAttribute("jugador") Jugador jugador) {
	        if (jugador.getId().isEmpty()) {
	            jugador.setId(null);
	        }
	        jugadorRepository.save(jugador);
	        return "redirect:/jugadores/";
	    }

	    @GetMapping("/delete/{id}")
	    public String jugadorDeleteProcess(@PathVariable("id") String id) {
	        jugadorRepository.deleteById(id);
	        return "redirect:/jugadores/";
	    }
	}
package com.example.mongo.oscar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongo.oscar.Entity.Asociacion;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.AsociacionRepository;
@Controller
@RequestMapping(value = "asociaciones")

public class AsociacionWebController {
	@Autowired
    private AsociacionRepository asociacionRepository;
	
	  @GetMapping("/")
	    public String asociacionesListTemplate(Model model) {
	        model.addAttribute("asociaciones", asociacionRepository.findAll());
	        return "asociaciones-list";
	    }

	    @GetMapping("/new")
	    public String asociacionesNewTemplate(Model model) {
	        model.addAttribute("asociacion", new Asociacion());
	        return "asociaciones-form";
	    }

	    @GetMapping("/edit/{id}")
	    public String asociacionEditTemplate(@PathVariable("id") String id, Model model) {
	        model.addAttribute("asociacion", asociacionRepository.findById(id).orElseThrow(() -> new NotFoundException("Asociacion no encontrado")));
	        return "asociaciones-form";
	    }

	    @PostMapping("/save")
	    public String asociacionesSaveProcess(@ModelAttribute("asociacion") Asociacion asociacion) {
	        if (asociacion.getId().isEmpty()) {
	            asociacion.setId(null);
	        }
	        asociacionRepository.save(asociacion);
	        return "redirect:/asociaciones/";
	    }

	    @GetMapping("/delete/{id}")
	    public String asociacionDeleteProcess(@PathVariable("id") String id) {
	        asociacionRepository.deleteById(id);
	        return "redirect:/asociaciones/";
	    }
	}
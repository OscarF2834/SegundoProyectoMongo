package com.example.mongo.oscar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongo.oscar.Entity.Director;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.DirectorRepository;
@Controller
@RequestMapping(value = "directores")

public class DirectorWebController {
	@Autowired
    private DirectorRepository directorRepository;
	
	  @GetMapping("/")
	    public String directoresListTemplate(Model model) {
	        model.addAttribute("directores", directorRepository.findAll());
	        return "directores-list";
	    }

	    @GetMapping("/new")
	    public String directoresNewTemplate(Model model) {
	        model.addAttribute("director", new Director());
	        return "directores-form";
	    }

	    @GetMapping("/edit/{id}")
	    public String directorEditTemplate(@PathVariable("id") String id, Model model) {
	        model.addAttribute("director", directorRepository.findById(id).orElseThrow(() -> new NotFoundException("Director no encontrado")));
	        return "directores-form";
	    }

	    @PostMapping("/save")
	    public String directoresSaveProcess(@ModelAttribute("asociacion") Director director) {
	        if (director.getId().isEmpty()) {
	            director.setId(null);
	        }
	        directorRepository.save(director);
	        return "redirect:/directores/";
	    }

	    @GetMapping("/delete/{id}")
	    public String directorDeleteProcess(@PathVariable("id") String id) {
	        directorRepository.deleteById(id);
	        return "redirect:/directores/";
	    }
	}

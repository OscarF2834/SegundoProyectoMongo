package com.example.mongo.oscar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongo.oscar.Entity.Competicion;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.CompeticionRepository;
@Controller
@RequestMapping(value = "competiciones")

public class CompeticionWebController {
	@Autowired
    private CompeticionRepository competicionRepository;
	
	  @GetMapping("/")
	    public String competicionesListTemplate(Model model) {
	        model.addAttribute("competiciones", competicionRepository.findAll());
	        return "competiciones-list";
	    }

	    @GetMapping("/new")
	    public String competicionesNewTemplate(Model model) {
	        model.addAttribute("competicion", new Competicion());
	        return "competiciones-form";
	    }

	    @GetMapping("/edit/{id}")
	    public String competicionEditTemplate(@PathVariable("id") String id, Model model) {
	        model.addAttribute("competicion", competicionRepository.findById(id).orElseThrow(() -> new NotFoundException("Competicion no encontrado")));
	        return "competiciones-form";
	    }

	    @PostMapping("/save")
	    public String competicionesSaveProcess(@ModelAttribute("competicion") Competicion competicion) {
	        if (competicion.getId().isEmpty()) {
	            competicion.setId(null);
	        }
	        competicionRepository.save(competicion);
	        return "redirect:/competiciones/";
	    }

	    @GetMapping("/delete/{id}")
	    public String competicionDeleteProcess(@PathVariable("id") String id) {
	        competicionRepository.deleteById(id);
	        return "redirect:/competiciones/";
	    }
	}
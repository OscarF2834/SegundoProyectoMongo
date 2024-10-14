package com.example.mongo.oscar.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.mongo.oscar.Entity.Director;
import com.example.mongo.oscar.Exception.NotFoundException;
import com.example.mongo.oscar.Repository.DirectorRepository;
@RestController
@RequestMapping(value = "/api/directores")
public class DirectorRestController {
	
	 @Autowired
	    private DirectorRepository directorRepository;
	 
	 @GetMapping("/")
	    public List<Director> getAllDirectores() {
	        return directorRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Director getDirectorById(@PathVariable String id) {
	        return directorRepository.findById(id).orElseThrow(() -> new NotFoundException("Director no encontrado"));
	    }

	    @PostMapping("/")
	    public Director saveDirector(@RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Director director = mapper.convertValue(body, Director.class);
	        return directorRepository.save(director);
	    }

	    @PutMapping("/{id}")
	    public Director updateDirector(@PathVariable String id, @RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Director director = mapper.convertValue(body, Director.class);
	        director.setId(id);
	        return directorRepository.save(director);
	    }

	    @DeleteMapping("/{id}")
	    public Director deleteDirector(@PathVariable String id) {
	        Director director = directorRepository.findById(id).orElseThrow(() -> new NotFoundException("Director no encontrado"));
	        directorRepository.deleteById(id);
	        return director;
	    }
}

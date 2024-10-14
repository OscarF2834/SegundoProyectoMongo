package com.example.mongo.oscar.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipos")
public class Equipo {
	
	@Id
	private String id;
	
	private String nombre;
	
	@DBRef
	private Asociacion asociacion;
	
	@DBRef
	private Director director;
	
	@DBRef
	private List<Competicion> competicion;
	
	@DBRef
	private List<Jugador> jugador;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Competicion> getCompeticion() {
		return competicion;
	}

	public void setCompeticion(List<Competicion> competicion) {
		this.competicion = competicion;
	}

	public List<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(List<Jugador> jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", asociacion=" + asociacion + ", director=" + director
				+ ", competicion=" + competicion + ", jugador=" + jugador + ", getId()=" + getId() + ", getNombre()="
				+ getNombre() + ", getAsociacion()=" + getAsociacion() + ", getDirector()=" + getDirector()
				+ ", getCompeticion()=" + getCompeticion() + ", getJugador()=" + getJugador() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	

}

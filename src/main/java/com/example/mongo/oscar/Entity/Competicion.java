package com.example.mongo.oscar.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "competicion")
public class Competicion {
	
	@Id
	private String id;
	private String nombre;
	private String premio;
	private String fechaInicio;
	private String fechaFin;
	
	public Competicion() {
	}

	public Competicion(String id, String nombre, String premio, String fechaInicio, String fechaFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.premio = premio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

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

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Competicion [id=" + id + ", nombre=" + nombre + ", premio=" + premio + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getPremio()="
				+ getPremio() + ", getFechaInicio()=" + getFechaInicio() + ", getFechaFin()=" + getFechaFin()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}

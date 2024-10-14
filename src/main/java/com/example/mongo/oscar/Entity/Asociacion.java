package com.example.mongo.oscar.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asociacion")
public class Asociacion {
	
	@Id
	private String id;
	private String nombre;
	private String pais;
	private String presidente;
	private String siglas;
	
	public Asociacion() {
	}

	public Asociacion(String id, String nombre, String pais, String presidente, String siglas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.presidente = presidente;
		this.siglas = siglas;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	@Override
	public String toString() {
		return "Asociacion [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", presidente=" + presidente
				+ ", siglas=" + siglas + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getPais()="
				+ getPais() + ", getPresidente()=" + getPresidente() + ", getSiglas()=" + getSiglas() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}	

}

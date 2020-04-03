package com.unsis.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {

	private long id;
	private String nombre;
	private String apellido;
	private String emailId;
	private String twitter;
	private String linkedin;
	private String cedula_prof;
	private String conacyt;
	private String instituto;
	private String contrasenia;
	
	public Profesor() {
		
	}
	

	
	public Profesor(long id, String nombre, String apellido, String emailId, String twitter, String linkedin,
			String cedula_prof, String conacyt, String instituto, String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.emailId = emailId;
		this.twitter = twitter;
		this.linkedin = linkedin;
		this.cedula_prof = cedula_prof;
		this.conacyt = conacyt;
		this.instituto = instituto;
		this.contrasenia = contrasenia;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido", nullable = false)
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = "twitter", nullable = true)
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
	@Column(name = "linkedin")
	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	@Column(name = "cedula_prof")
	public String getCedula_prof() {
		return cedula_prof;
	}

	public void setCedula_prof(String cedula_prof) {
		this.cedula_prof = cedula_prof;
	}
	@Column(name = "conacyt")
	public String getConacyt() {
		return conacyt;
	}

	public void setConacyt(String conacyt) {
		this.conacyt = conacyt;
	}
	@Column(name ="conacyt")
	public String getInstituto() {
		return this.instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	@Column(name ="contrasenia")
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", emailId=" + emailId
				+ "]";
	}


	
}

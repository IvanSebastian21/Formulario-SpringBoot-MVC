package com.springboot.form.app.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	private String identificador; 
	@NotEmpty(message="Se debe introducir un nombre, no puede estar vacío")
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Size(min=3, max=8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty(message="Formato email incorrecto")
	@Email
	private String email;
	
	public Usuario() {
	}

	public Usuario(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

}

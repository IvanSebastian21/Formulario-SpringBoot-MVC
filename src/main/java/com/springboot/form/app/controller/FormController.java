package com.springboot.form.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.form.app.domain.Usuario;

@Controller
@SessionAttributes("usuario")

/*
@SessionAttributes es una anotación de Spring Boot:
	que se utiliza para mantener los atributos del modelo en la sesión HTTP. 
	Esto significa que los atributos del modelo se pueden mantener en la sesión HTTP
	Y entre múltiples solicitudes del usuario.
*/
public class FormController {

	@GetMapping("/")
	public String form(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("ivan");
		usuario.setApellido("nuñez");
		usuario.setIdentificador("123.64.789-k");
		model.addAttribute("titulo", "Formulario de usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

		model.addAttribute("titulo", "Resultado del formulario");

		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("usuario", usuario);
		status.setComplete();

		return "resultado";
	}
}

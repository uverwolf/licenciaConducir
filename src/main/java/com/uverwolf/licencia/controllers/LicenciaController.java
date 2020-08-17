package com.uverwolf.licencia.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uverwolf.licencia.models.License;
import com.uverwolf.licencia.models.Person;
import com.uverwolf.licencia.services.LicenciaServices;

@Controller
public class LicenciaController {
	private final LicenciaServices servicios;
	public LicenciaController(LicenciaServices serv) {
		this.servicios= serv;
	}
	
	@GetMapping("/index")
	public String index() {
		servicios.todasPersonas();
		return "vistas/index.jsp";
	}
	@GetMapping("licencia/persona")
	public String crearPersona(@ModelAttribute("personaValida")Person persona) {
		return "vistas/persona.jsp";
	}
	
	@PostMapping("licencia/persona")
	public String agregarPersona(@Valid @ModelAttribute("persona") Person persona,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return"vistas/persona.jsp";
		}else {
			servicios.agregar(persona);
			return "redirect:/index";
		}
	}
	
	
	@GetMapping("licencia/licencia")
	public String crearLicencia(@ModelAttribute("licenciaValida")License licen,Model modelo) {
		
		modelo.addAttribute("personas", servicios.personasDisponibles());
	
		return "vistas/licencia.jsp";
	}
	@PostMapping("licencia/licencia")
	public String agregarLicencia(@Valid @ModelAttribute("licenciaValida") License licencia,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return"vistas/licencia.jsp";
		}else {
			
			
			licencia.setNumber(servicios.getNumero());
			
			servicios.agregarLicencia(licencia);
			return "redirect:/index";
		}
	}
}

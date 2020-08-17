package com.uverwolf.licencia.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uverwolf.licencia.models.Person;
import com.uverwolf.licencia.services.LicenciaServices;

@RestController
public class ApiLicen {
	
	private final LicenciaServices servicios;
	public ApiLicen(LicenciaServices serv) {
		this.servicios= serv;
	}
	@GetMapping("/api/dashboard")
	public List<Person> dasboard(Model modelo) {
		return servicios.todasPersonas();
		
	}
	@PostMapping("/api/dashboard/")
	public Person agregar(@RequestParam("nombre") String nombre,@RequestParam("apellido") String apellido) {
		Person persona=new Person(nombre, apellido);
		return servicios.agregar(persona);
	}
}

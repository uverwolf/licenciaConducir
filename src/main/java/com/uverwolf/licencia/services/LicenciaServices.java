package com.uverwolf.licencia.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.uverwolf.licencia.models.License;
import com.uverwolf.licencia.models.Person;
import com.uverwolf.licencia.repositories.LicenseRepo;
import com.uverwolf.licencia.repositories.PersonRepositories;

@Service
public class LicenciaServices {
	private final PersonRepositories repoPersona;
	private final LicenseRepo repoLicen;
	
	public LicenciaServices (PersonRepositories repoP, LicenseRepo reporli) {
		this.repoPersona =repoP;
		this.repoLicen=reporli;
	}
	
	
	public List<Person> todasPersonas(){
		return repoPersona.findAll();
	}
	public Person agregar(Person persona) {
		return repoPersona.save(persona);
	}
	
public List<Person> personasDisponibles(){
	return repoPersona.findByLicensePerson_idIsNull();
	}
	public String getNumero() {
		if(repoLicen.findTopByOrderByNumberDesc().isEmpty()) {
			int numero =1;
			return stringNumero(numero);
		}else {
			List<License> top = repoLicen.findTopByOrderByNumberDesc() ;
			int numero = 1+(Integer.parseInt(top.get(0).getNumber()));
			return  stringNumero(numero);
		}
	
	}
	
	
	private String stringNumero(int numero) {
		
		return "0000"+numero;
	}


	public License agregarLicencia( License licencia) {

			return repoPersona.save(licencia);
		
		
		
	}
}
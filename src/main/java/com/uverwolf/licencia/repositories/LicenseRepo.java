package com.uverwolf.licencia.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.uverwolf.licencia.models.License;
import com.uverwolf.licencia.models.Person;

public interface LicenseRepo extends CrudRepository<License, Long> {
	List<License>findTopByOrderByNumberDesc();

	List<Person>findByPersonFirstNameIsNotNullAndPerson_idIsNull();	
	
	//findByPersonFirstNameIsNotNullAndPerson_idIsNull

	
}

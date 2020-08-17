package com.uverwolf.licencia.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.uverwolf.licencia.models.License;
import com.uverwolf.licencia.models.Person;


public interface PersonRepositories extends CrudRepository<Person, Long>{

	List<Person> findAll();

	License save(License licencia);
	
	@Query("SELECT u.first_name FROM Person u inner join License on  u.id = person_id")
	List<Person> findByLicensePerson_idIsNull();
//	@Query("SELECT persons.first_name FROM persons left join licenses on persons.id = licenses.person_id where licenses.person_id is null")

}

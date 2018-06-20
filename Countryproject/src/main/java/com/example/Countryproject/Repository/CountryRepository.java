package com.example.Countryproject.Repository;

import com.example.Countryproject.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

	// Country findOne(long id);

	//  void delete(long id);


	// void deleteAll(long id);


    
    }
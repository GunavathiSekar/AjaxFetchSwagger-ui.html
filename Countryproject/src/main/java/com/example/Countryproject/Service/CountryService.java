package com.example.Countryproject.Service;

import java.util.List;

import com.example.Countryproject.model.Country;
public interface CountryService {
	
    public void saveCountry(Country country);
    public List<Country> findAll();
    public void updateCountry(Country country,Long id);
	 public Country findOne(long id);
    public void delete(long id);
}

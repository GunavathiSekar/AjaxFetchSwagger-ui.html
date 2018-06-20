package com.example.Countryproject.Service;

import java.util.List;
import com.example.Countryproject.Repository.CountryRepository;
import com.example.Countryproject.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceimp implements CountryService{
    @Autowired
    private CountryRepository countryRepository;

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

    @Override
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public void updateCountry(Country country, Long id) {
        country.setCountryid(id);
        countryRepository.saveAndFlush(country);
        
	}

	@Override
	public Country findOne(long id) {
		return countryRepository.getOne(id);
	 }

	@Override
	public void delete(long id) {
		countryRepository.deleteById(id);;
	}

}
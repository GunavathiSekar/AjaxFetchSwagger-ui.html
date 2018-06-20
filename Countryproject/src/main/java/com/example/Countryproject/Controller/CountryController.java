package com.example.Countryproject.Controller;

import java.util.List;

import com.example.Countryproject.Service.CountryService;
import com.example.Countryproject.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

@RequestMapping("/country")
public class CountryController{
    @Autowired
    private CountryService countryservice;
    
    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ResponseEntity<?> saveCountry(@RequestBody Country country){
        countryservice.saveCountry(country);
        return new ResponseEntity<Country>(country,HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCountry(@PathVariable Long id) {
		countryservice.delete(id);
   }
    @RequestMapping(method = RequestMethod.GET)
	public List<Country> getCountry() {
		return countryservice.findAll();
	}
  
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Country getCountry(@PathVariable Long id) {
		return countryservice.findOne(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    
    public ResponseEntity<?> updateFlight(@RequestBody Country flight, @PathVariable("id") Long id) {
        Country f1=flight;
        countryservice.updateCountry(f1, id);           
        return new ResponseEntity<Country>(HttpStatus.OK);
    
    }

}
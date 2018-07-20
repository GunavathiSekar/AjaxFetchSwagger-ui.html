
 
/**
 * Country.java
 * This is a model class represents a Country entity
 * @country www.codejava.net
 *
 */
public class Country {
    protected int country_id;
    protected String country_name;
    protected String country_abbr;
    public Country() {
    }
    public Country(int country_id) {
        this.country_id = country_id;
    }
 
    public Country(int country_id, String country_name, String country_abbr) {
        this(country_name, country_abbr);
        this.country_id = country_id;
    }
     
    public Country(String country_name, String country_abbr) {
        this.country_name = country_name;
        this.country_abbr = country_abbr;
       
    }
 
    public int getCountry_id() {
        return country_id;
    }
 
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
 
    public String getCountry_name() {
        return country_name;
    }
 
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
 
    public String getCountry_abbr() {
        return country_abbr;
    }
 
    public void setCountry_abbr(String country_abbr) {
        this.country_abbr = country_abbr;
    }
 
   
}
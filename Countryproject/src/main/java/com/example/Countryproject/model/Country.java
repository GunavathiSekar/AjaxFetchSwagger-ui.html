package com.example.Countryproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long countryid;
    @Column
    private String countryname;

    /**
     * @param countryid the countryid to set
     */
    public void setCountryid(Long countryid) {
        this.countryid = countryid;
    }
    /**
     * @return the countryid
     */
    public Long getCountryid() {
        return countryid;
    }
    /**
     * @param countryname the countryname to set
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
    /**
     * @return the countryname
     */
    public String getCountryname() {
        return countryname;
    }
    @Override
    public String toString() {
        return "["+countryid+" "+countryname+"]";
    }
}
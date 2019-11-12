/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

/**
 * Employee class
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
public class Employee {
    
    private String id = "";
    private String name = "";
    private String first_name = "";
    private String home_phone = "";
    private String mobi_phone = "";
    private String work_phone = "";
    private String address = "";
    private String postal_code = "";
    private String city = "";
    private String email = "";
    
    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getId() {
        return id;
    }

    /**
     * Classic set method
     * @param name
     */
    public void setId(String name) {
        this.id = name;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getName() {
        return name;
    }

    /**
     * Classic set method
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Classic set method
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getHome_phone() {
        return home_phone;
    }

    /**
     * Classic set method
     * @param home_phone
     */
    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getMobi_phone() {
        return mobi_phone;
    }

    /**
     * Classic set method
     * @param mobi_phone
     */
    public void setMobi_phone(String mobi_phone) {
        this.mobi_phone = mobi_phone;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getWork_phone() {
        return work_phone;
    }

    /**
     * Classic set method
     * @param work_phone
     */
    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getAddress() {
        return address;
    }

    /**
     * Classic set method
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * Classic set method
     * @param postal_code
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getCity() {
        return city;
    }

    /**
     * Classic set method
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Classic get method
     * @return the attribute to get
     */    
    public String getEmail() {
        return email;
    }

    /**
     * Classic set method
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

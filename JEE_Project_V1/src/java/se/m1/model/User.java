/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

/**
 * User class
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
public class User {
    
    private String login;
    private String pwd;

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getLogin() {
        return login;
    }

    /**
     * Classic set method
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Classic set method
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
   
}

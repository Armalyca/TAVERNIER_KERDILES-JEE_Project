/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean for credentials
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
@Stateless
public class CredentialsSB {
    @PersistenceContext
    EntityManager em;
        
    /**
     * Method to check if input credentials are valid
     * @param creds credentials to check
     * @return true if creds are valid credentials, false otherwise
     */
    public Boolean isValid( Credentials creds ) throws SQLException{
        Query q = em.createNamedQuery("Credentials.check");
        
        q.setParameter("login", creds.getLogin());
        q.setParameter("pwd", creds.getPwd());

        if( q.getResultList().isEmpty() ) return false;
        return true;
    }   
}

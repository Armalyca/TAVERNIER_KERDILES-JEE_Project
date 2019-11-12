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
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Session Bean for employees
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
@Stateless
public class EmployeesSB {
    
    @PersistenceContext
    EntityManager em; 
    
    /**
     * Get all employees in database
     * @return the list of employees
     */
    public List getEmployees() throws Exception {
        Query q = em.createNamedQuery("Employees.findAll");
        return q.getResultList();
        
    }
    
    /**
     * Get an employee by ID
     * @param id the employee ID
     * @return the employee if found
     */
    public Employees getEmployeeByID( String id ) throws Exception {
        TypedQuery<Employees> q = em.createNamedQuery("Employees.findById", Employees.class);
        q.setParameter("id", Integer.parseInt(id));
        return q.getSingleResult();
    }
    
    /**
     * Delete an employee by ID
     * @param id the employee ID
     */
    public void deleteEmployee(String id) throws Exception {
        Employees employee = em.find(Employees.class, Integer.parseInt(id));
        em.remove(employee);
    }
    
    /**
     * Add and employee
     * @param employee the employee to add in database
     */
    public void add(Employees employee) throws Exception {  
        em.persist(employee);
    }
    
    /**
     * Update an employee
     * @param emp_update the employee bean holding data to update in database
     */
    public void update( Employees emp_update ) throws Exception {
        Employees employee = em.find(Employees.class, emp_update.getId());

        employee.setName( emp_update.getName() );
        employee.setFirstname( emp_update.getFirstname() );
        employee.setTelhome( emp_update.getTelhome() );
        employee.setTelmob( emp_update.getTelmob() );
        employee.setTelpro( emp_update.getTelpro() );
        employee.setAdress( emp_update.getAdress() );
        employee.setPostalcode( emp_update.getPostalcode() );
        employee.setEmail( emp_update.getEmail() );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class from database (employees table)
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id")
    , @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name")
    , @NamedQuery(name = "Employees.findByFirstname", query = "SELECT e FROM Employees e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employees.findByTelhome", query = "SELECT e FROM Employees e WHERE e.telhome = :telhome")
    , @NamedQuery(name = "Employees.findByTelmob", query = "SELECT e FROM Employees e WHERE e.telmob = :telmob")
    , @NamedQuery(name = "Employees.findByTelpro", query = "SELECT e FROM Employees e WHERE e.telpro = :telpro")
    , @NamedQuery(name = "Employees.findByAdress", query = "SELECT e FROM Employees e WHERE e.adress = :adress")
    , @NamedQuery(name = "Employees.findByPostalcode", query = "SELECT e FROM Employees e WHERE e.postalcode = :postalcode")
    , @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
})

public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELHOME")
    private String telhome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELMOB")
    private String telmob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELPRO")
    private String telpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ADRESS")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CITY")
    private String city;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;

    /**
     * Empty constructor for Employees
     */
    public Employees() {
    }

    /**
     * Simple constructor for Employees
     * @param id
     */
    public Employees(Integer id) {
        this.id = id;
    }

    /**
     * Full constructor for Employees
     * @param id
     * @param name
     * @param firstname
     * @param telhome
     * @param telmob
     * @param telpro
     * @param adress
     * @param postalcode
     * @param city
     * @param email
     */
    public Employees(Integer id, String name, String firstname, String telhome, String telmob, String telpro, String adress, String postalcode, String city, String email) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.telhome = telhome;
        this.telmob = telmob;
        this.telpro = telpro;
        this.adress = adress;
        this.postalcode = postalcode;
        this.city = city;
        this.email = email;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public Integer getId() {
        return id;
    }

    /**
     * Classic set method
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
    public String getFirstname() {
        return firstname;
    }

    /**
     * Classic set method
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getTelhome() {
        return telhome;
    }

    /**
     * Classic set method
     * @param telhome
     */
    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getTelmob() {
        return telmob;
    }

    /**
     * Classic set method
     * @param telmob
     */
    public void setTelmob(String telmob) {
        this.telmob = telmob;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getTelpro() {
        return telpro;
    }

    /**
     * Classic set method
     * @param telpro
     */
    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Classic set method
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * Classic set method
     * @param postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.m1.model.Employees[ id=" + id + " ]";
    }
    
}

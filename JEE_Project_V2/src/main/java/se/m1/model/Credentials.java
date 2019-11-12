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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class from database (credentials table)
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
@Entity
@Table(name = "credentials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentials.findAll", query = "SELECT c FROM Credentials c")
    , @NamedQuery(name = "Credentials.findById", query = "SELECT c FROM Credentials c WHERE c.id = :id")
    , @NamedQuery(name = "Credentials.findByLogin", query = "SELECT c FROM Credentials c WHERE c.login = :login")
    , @NamedQuery(name = "Credentials.findByPwd", query = "SELECT c FROM Credentials c WHERE c.pwd = :pwd")
    , @NamedQuery(name = "Credentials.check", query = "SELECT c FROM Credentials c WHERE c.pwd = :pwd AND c.login = :login")
})
public class Credentials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pwd")
    private String pwd;

    /**
     * Empty constructor for Credentials
     */
    public Credentials() {
    }

    /**
     * Simple constructor for Credentials
     * @param id
     */
    public Credentials(Integer id) {
        this.id = id;
    }

    /**
     * Full constructor for Credentials
     * @param id
     * @param login
     * @param pwd
     */
    public Credentials(Integer id, String login, String pwd) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
    }

    /**
     * Classic get method
     * @return the attribute to get
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Classic get method
     * @return the attribute to get
     */
    public String getLogin() {
        return login;
    }

    /**
     *
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
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
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
        if (!(object instanceof Credentials)) {
            return false;
        }
        Credentials other = (Credentials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.m1.model.Credentials[ id=" + id + " ]";
    }
    
}

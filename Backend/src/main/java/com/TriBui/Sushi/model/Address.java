/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TriBui.Sushi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author This MC
 */
@Entity
@Table(name = "Address", catalog = "Sushi", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "Address.findByAddressCity", query = "SELECT a FROM Address a WHERE a.addressCity = :addressCity"),
    @NamedQuery(name = "Address.findByAddressDistrict", query = "SELECT a FROM Address a WHERE a.addressDistrict = :addressDistrict"),
    @NamedQuery(name = "Address.findByAddressStreet", query = "SELECT a FROM Address a WHERE a.addressStreet = :addressStreet")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AddressID", nullable = false, length = 50)
    private String addressID;
    @Size(max = 50)
    @Column(name = "AddressCity", length = 50)
    private String addressCity;
    @Size(max = 50)
    @Column(name = "AddressDistrict", length = 50)
    private String addressDistrict;
    @Size(max = 100)
    @Column(name = "AddressStreet", length = 100)
    private String addressStreet;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userID;

    public Address() {
    }

    public Address(String addressID) {
        this.addressID = addressID;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TriBui.Sushi.model.Address[ addressID=" + addressID + " ]";
    }
    
}

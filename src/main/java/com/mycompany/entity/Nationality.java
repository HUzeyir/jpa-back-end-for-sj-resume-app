/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nationality implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String countryName;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDetail userDetail;

    public Nationality() {
    }

    public Nationality(Short id, String countryName, UserDetail userDetail) {
        this.id = id;
        this.countryName = countryName;
        this.userDetail = userDetail;
    }

    public Nationality(String countryName) {
        this.countryName = countryName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public UserDetail getUser() {
        return userDetail;
    }

    public void setUser(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nationality other = (Nationality) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nationality{" + "id=" + id + ", countryName=" + countryName + ", user=" + userDetail + '}';
    }

}

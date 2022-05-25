/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HuzeyirPc
 */
@Entity
public class Education implements Serializable {

    public static final Long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "uni_name")
    private String uniName;
    private String faculty;
    private String speciality;
    @Column(name = "admitted_date")
    @Temporal(TemporalType.DATE)
    private Date admittedDate;
    @Column(name = "graduated_date")
    @Temporal(TemporalType.DATE)
    private Date graduatedDate;

    @ManyToMany
    private List<User> users;

    public Education() {
    }

    public Education(Short id, String uniName, String faculty, String speciality, Date admittedDate, Date graduatedDate, List<User> users) {
        this.id = id;
        this.uniName = uniName;
        this.faculty = faculty;
        this.speciality = speciality;
        this.admittedDate = admittedDate;
        this.graduatedDate = graduatedDate;
        this.users = users;
    }

    public Education(String uniName, String faculty, String speciality, Date admittedDate, Date graduatedDate, List<User> users) {
        this.uniName = uniName;
        this.faculty = faculty;
        this.speciality = speciality;
        this.admittedDate = admittedDate;
        this.graduatedDate = graduatedDate;
        this.users = users;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Date getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    public Date getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(Date graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Education other = (Education) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", uniName=" + uniName + ", faculty=" + faculty + ", speciality=" + speciality + ", admittedDate=" + admittedDate + ", graduatedDate=" + graduatedDate + ", users=" + users + '}';
    }

}

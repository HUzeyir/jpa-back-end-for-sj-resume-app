package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "User.findAllUser", query = "select u from User u"),
    @NamedQuery(name = "User.findUserById", query = "select u from User u where u.id= :id"),
    @NamedQuery(name = "User.findUserFullById", query = "select u from User u left join u.userDetail ud left join ud.address a left join ud.educations e"
            + " left join ud.experience ex left join ud.language lan left join ud.link l left join ud.naties nat left join ud.phone p "
            + "left join ud.userSkills us left join us.skill s where u.id= :id"),
    @NamedQuery(name = "User.findUserByEmail", query = " select u from User u where u.email= :email")})
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetail userDetail;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public User() {
    }

    public User(Long id, String name, String surName, String email, String password, UserDetail userDetail, Date addDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.userDetail = userDetail;
        this.addDate = addDate;
        this.updateDate = updateDate;
    }

    public User(String name, String surName, String email, String password, UserDetail userDetail, Date addDate, Date updateDate) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.userDetail = userDetail;
        this.addDate = addDate;
        this.updateDate = updateDate;
    }

    public User(String name, String surName, String email, String password) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surName=" + surName + ", email=" + email + ", password=" 
                + password + ", userDetail=" + userDetail + ", addDate=" + addDate + ", updateDate=" + updateDate + '}';
    }

}

package com.mycompany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetail implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String about;
    @Temporal(TemporalType.DATE)
    private Date age;
    private Date addDate = new Date();
    private Date updateDate;

    @OneToOne(cascade = CascadeType.ALL)
//    @Column(name = "address_id")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetail", fetch = FetchType.LAZY)
    private List<Experience> experience = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Language> languages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Link> links = new ArrayList<>();

    @OneToMany(mappedBy = "userDetail")
    private List<Nationality> naties = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    @OneToOne(mappedBy = "userDetail")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetail")
    private List<UserSkill> userSkills = new ArrayList<>();

    public UserDetail() {
    }

    public void addEducation(Education edu) {

        this.educations.add(edu);
    }

    public UserDetail(Long id, String about, Date age, Date addDate, Date updateDate, Address address, User user) {
        this.id = id;
        this.about = about;
        this.age = age;
        this.addDate = addDate;
        this.updateDate = updateDate;
        this.address = address;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Nationality> getNaties() {
        return naties;
    }

    public void setNaties(List<Nationality> naties) {
        this.naties = naties;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final UserDetail other = (UserDetail) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDetail{" + "id=" + id + ", about=" + about + ", age=" + age + ", addDate=" + addDate + ", updateDate=" + updateDate + ", address=" + address + ", educations=" + educations + ", experience=" + experience + ", languages=" + languages + ", links=" + links + ", naties=" + naties + ", phones=" + phones + ", user=" + user + ", userSkills=" + userSkills + '}';
    }

}
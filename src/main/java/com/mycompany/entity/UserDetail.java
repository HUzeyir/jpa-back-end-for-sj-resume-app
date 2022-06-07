package com.mycompany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
    @Lob
    private String about;

    @Lob
    private String image;

    @Temporal(TemporalType.DATE)
    private Date age;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date addDate = new Date();
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date updateDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "userDetail_educations")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetail", fetch = FetchType.LAZY)
    private List<Experience> experience = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Language language;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Link link;

    @OneToMany(mappedBy = "userDetail", fetch = FetchType.LAZY)
    private List<Nationality> naties = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Phone phone;

    @OneToOne(mappedBy = "userDetail")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetail", fetch = FetchType.LAZY)
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

    public UserDetail(String about, Date age) {
        this.about = about;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguages(Language language) {
        this.language = language;
    }

    public Link getLinks() {
        return link;
    }

    public void setLinks(Link link) {
        this.link = link;
    }

    public List<Nationality> getNaties() {
        return naties;
    }

    public void setNaties(List<Nationality> naties) {
        this.naties = naties;
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

    public void addUserSkill(UserSkill us) {
        this.userSkills.add(us);
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
        return "UserDetail: " + "\n id: " + id + "\n about: " + about + "\n age: " + age + "\n addDate: " 
                + addDate + "\n updateDate: " + updateDate;

    }
}

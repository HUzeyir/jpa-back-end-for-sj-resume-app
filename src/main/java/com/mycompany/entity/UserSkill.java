package com.mycompany.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserSkill implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte power;

    @OneToOne
    private Skill skill;

    @ManyToOne
    private UserDetail userDetail;

    public UserSkill() {
    }

    public UserSkill(Long id, byte power, Skill skill, UserDetail userDetail) {
        this.id = id;
        this.power = power;
        this.skill = skill;
        this.userDetail = userDetail;
    }

    public UserSkill(byte power, Skill skill) {
        this.power = power;
        this.skill = skill;
    }

    
    public UserSkill(byte power, Skill skill, UserDetail userDetail) {
        this.power = power;
        this.skill = skill;
        this.userDetail = userDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getPower() {
        return power;
    }

    public void setPower(byte power) {
        this.power = power;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final UserSkill other = (UserSkill) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", power=" + power + ", skill=" + skill + ", userDetail=" + userDetail + '}';
    }

}

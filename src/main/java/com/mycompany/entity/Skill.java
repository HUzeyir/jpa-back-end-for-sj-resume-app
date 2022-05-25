/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author HuzeyirPc
 */

@Entity
public class Skill implements Serializable {

    public static final long serialUID = 1L;

    private Short skilId;
    private String skillName;
    private Byte power;
    private User user;

    public Skill() {
    }

    public Skill(Short skilId, String skillName, Byte power, User user) {
        this.skilId = skilId;
        this.skillName = skillName;
        this.power = power;
        this.user = user;
    }

    public Short getSkilId() {
        return skilId;
    }

    public void setSkilId(Short skilId) {
        this.skilId = skilId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.skilId);
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
        final Skill other = (Skill) obj;
        if (!Objects.equals(this.skilId, other.skilId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Skill{" + "skilId=" + skilId + ", skillName=" + skillName + ", power=" + power + ", user=" + user + '}';
    }

}

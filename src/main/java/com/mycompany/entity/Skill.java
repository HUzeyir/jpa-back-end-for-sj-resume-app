
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Skill implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short skilId;
    
    private String skillName;
    
    @OneToOne(mappedBy = "skill")
    private UserSkill userSkill;
    
    
    public Skill() {
    }

    public Skill(Short skilId, String skillName) {
        this.skilId = skilId;
        this.skillName = skillName;
    }

    public Skill(String skillName) {
        this.skillName = skillName;
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
        return "\nskillName: " + skillName;
    }

}

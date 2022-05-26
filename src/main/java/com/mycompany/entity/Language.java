/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import com.mycompany.entity.util.LanguageLevel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

@Entity
public class Language implements Serializable {

    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @ElementCollection
    @CollectionTable(name = "user_language")
    @MapKeyColumn(name = "laguage_level")
    private Map<LanguageLevel, String> languages = new HashMap<>();

    @ManyToOne
//    @Column(name = "user_id")
    private UserDetail userDetail;

    public Language() {
    }

    public Language(Short id, Map<LanguageLevel, String> languages, UserDetail user) {
        this.id = id;
        this.languages = languages;
        this.userDetail = userDetail;
    }

    public void addLanguage(LanguageLevel level, String langage) {
        this.languages.put(level, langage);
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Map<LanguageLevel, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<LanguageLevel, String> languages) {
        this.languages = languages;
    }

    public UserDetail getUser() {
        return userDetail;
    }

    public void setUser(UserDetail user) {
        this.userDetail = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Language other = (Language) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Language{" + "id=" + id + ", languages=" + languages + ", user=" + userDetail + '}';
    }

}

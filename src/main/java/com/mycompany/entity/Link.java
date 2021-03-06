
package com.mycompany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Link implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @ElementCollection
    @CollectionTable(name = "userDetail_link")
    private List<String> linkName = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "link")
    private UserDetail userDetail;

    public Link() {
    }

    public Link(Short id, User user) {
        this.id = id;
        this.userDetail = userDetail;
    }

    public void addLink(String link) {
        this.linkName.add(link);
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public List<String> getLinkName() {
        return linkName;
    }

    public void setLinkName(List<String> linkName) {
        this.linkName = linkName;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Link other = (Link) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Link{" + "id=" + id + ", linkName=" + linkName + '}';
    }

}

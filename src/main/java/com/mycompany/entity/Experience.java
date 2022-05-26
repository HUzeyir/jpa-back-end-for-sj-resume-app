
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Experience implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String position;
    @Lob
    private String obligations;

    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    private boolean isCurrentWork;
    @ManyToOne
//    @Column(name="user_detail_id")
    private UserDetail userDetail;

    public Experience() {
    }

    public Experience(Long id, String companyName, String position, String obligations, Date hireDate, Date endDate, boolean isCurrentWork, UserDetail userDetail) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.obligations = obligations;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.isCurrentWork = isCurrentWork;
        this.userDetail = userDetail;
    }

    public Experience(String companyName, String position, String obligations, Date hireDate, Date endDate, boolean isCurrentWork, UserDetail userDetail) {
        this.companyName = companyName;
        this.position = position;
        this.obligations = obligations;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.isCurrentWork = isCurrentWork;
        this.userDetail = userDetail;
    }

    public Experience(String companyName, String position, String obligations, Date hireDate, Date endDate, boolean isCurrentWork) {
        this.companyName = companyName;
        this.position = position;
        this.obligations = obligations;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.isCurrentWork = isCurrentWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getObligations() {
        return obligations;
    }

    public void setObligations(String obligations) {
        this.obligations = obligations;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isIsCurrentWork() {
        return isCurrentWork;
    }

    public void setIsCurrentWork(boolean isCurrentWork) {
        this.isCurrentWork = isCurrentWork;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Experience other = (Experience) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", companyName=" + companyName + ", position=" + position + ", obligations=" + obligations + ", hireDate=" + hireDate + ", endDate=" + endDate + ", isCurrentWork=" + isCurrentWork + ", userDetail=" + userDetail + '}';
    }

}

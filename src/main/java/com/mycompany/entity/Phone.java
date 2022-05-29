package com.mycompany.entity;

import com.mycompany.entity.util.PhoneType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

@Entity
public class Phone implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    @ElementCollection
    @CollectionTable(name = "userDetail_phone")
    @JoinColumn(name = "phone_id")
    @Column(name="number")
    @MapKeyColumn(name="phone_type")
    private Map<PhoneType, String> number = new HashMap<>();
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "phone")
    private UserDetail userDetail;

    public Phone() {
    }

    public Phone(byte id, UserDetail userDetail) {
        this.id = id;
        this.userDetail = userDetail;
    }

    public void addNumber(PhoneType phoneType, String numb) {
        this.number.put(phoneType, numb);
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Map<PhoneType, String> getNumber() {
        return number;
    }

    public void setNumber(Map<PhoneType, String> number) {
        this.number = number;
    }

    public UserDetail getUser() {
        return userDetail;
    }

    public void setUser(UserDetail user) {
        this.userDetail = userDetail;
    }

}

package com.mycompany.entity;

import com.mycompany.entity.util.PhoneType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    @ElementCollection
    @CollectionTable(name = "user_phone")
    @JoinColumn(name = "user_id")
    private Map<PhoneType, String> number = new HashMap<>();
    @ManyToOne
//    @Column(name = "user_id")
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

package com.example.andre.costumlist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xiiip on 10/21/2016.
 */
public class Student implements Serializable {
    private int id;
    private String noreg;
    private String phone;
    private String mail;
    private String name;

    public Student(int id, String noreg, String name, String phone, String mail) {
        this.setId(id);
        this.noreg = noreg;
        this.setName(name);
        this.setMail(mail);
        this.setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
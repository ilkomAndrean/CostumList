package com.example.andre.costumlist;

import android.os.Parcelable;
import android.os.Parcel;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by xiiip on 10/21/2016.
 */
public class Teacher implements Serializable {
    static ArrayList<Student> Teacherlist;
    private int id;
    private String Nip;
    private String Nama;
    private String Mail;
    private String Phone;

    public Teacher(int id, String Nip, String Nama, String Mail, String Phone){
        this.id = id;
        this.Nip = Nip;
        this.Nama = Nama;
        this.Mail = Mail;
        this.Phone = Phone;
    }

    public int getId() {return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return Nip;
    }

    public void setNip(String Nip) {
        Nip = Nip;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


}
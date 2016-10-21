package com.example.andre.costumlist;

import android.os.Parcelable;
import android.os.Parcel;



/**
 * Created by xiiip on 10/21/2016.
 */
public class Student implements Parcelable{
    private int id;
    private String noreg;
    private String name;
    private String mail;
    private String phone;

    public Student(int id, String noreg, String name, String mail, String phone){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.noreg = noreg;
    }

    public Student(Parcel in) {
        id = in.readInt();
        noreg = in.readString();
        name = in.readString();
        mail = in.readString();
        phone = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getNoreg());
        dest.writeString(getName());
        dest.writeString(getMail());
        dest.writeString(getPhone());
    }
}
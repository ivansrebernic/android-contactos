package com.example.agenda;

import android.content.ContentValues;

import java.io.Serializable;
import java.sql.Date;

public class Contact implements Serializable {

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String avatarUrl;
    private String birthday;

    public Contact(int id, String name, String surname, String phoneNumber, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public Contact(String name, String surname, String phoneNumber, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    //GETTERS
    public int getID() {return id;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBirthday() {
        return birthday;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //

    public ContentValues toContentValues() {
        //Creates an instance of ContentValues storing all the information of the contact
        ContentValues values = new ContentValues();
        values.put(ContactContract.ContactEntry.NAME, name);
        values.put(ContactContract.ContactEntry.SURNAME, surname);
        //values.put(ContactContract.ContactEntry.NICKNAME, nickname);
        values.put(ContactContract.ContactEntry.PHONE_NUMBER, phoneNumber);
        values.put(ContactContract.ContactEntry.BIRTHDAY, birthday);

        return values;
    }
}

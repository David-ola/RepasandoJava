package com.company.models;

import java.util.Calendar;

public class Alumn {
    private String name;
    private String surname1;
    private String surname2;
    private Calendar birthdate;
    private String id;

    public Alumn(String name, String surname1, String surname2, Calendar birthdate, String id) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthdate = birthdate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - this.birthdate.get(Calendar.YEAR);
        int monthDiff = today.get(Calendar.MONTH) - this.birthdate.get(Calendar.MONTH);
        int dayDiff = today.get(Calendar.DAY_OF_MONTH) - this.birthdate.get(Calendar.DAY_OF_MONTH);
        if (monthDiff < 0 || (monthDiff == 0 && dayDiff < 0)) {
            age -= 1;
        }
        return age;
    }
}

package com.company;

import com.company.models.Alumn;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Calendar birth = new GregorianCalendar(2000, Calendar.JULY, 11);
        Alumn alumn = new Alumn("Pepe", "Pepez", "Pepez", birth, "123");
        System.out.println(alumn.getName() + " tiene " + alumn.getAge() + " años");
    }
}

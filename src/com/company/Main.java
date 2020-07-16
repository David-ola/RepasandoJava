package com.company;

import com.company.Modelos.Alumno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        Date nacimiento=null;
        try {
           nacimiento = fecha.parse("16-07-1981");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Alumno alumno=new Alumno("Juan","Perez",nacimiento,"3456545F");
        System.out.println(alumno.toString());
        System.out.println("La edad de "+alumno.getNombre()+ " es: "+alumno.getEdad());

        try {
            nacimiento =fecha.parse("15-07-1985");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Alumno alumno2=new Alumno("Xose","Martinez",nacimiento,"2123233D");
        System.out.println(alumno2.toString());
        System.out.println("La edad de "+alumno2.getNombre()+ " es: "+alumno2.getEdad());
        try {
            nacimiento=fecha.parse("16-08-1985");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Alumno alumno3=new Alumno("Maria","Lopez",nacimiento,"1235562121S");
        System.out.println(alumno3.toString());
        System.out.println("La edad de "+alumno3.getNombre()+ " es: "+alumno3.getEdad());
    }
}

package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        Date nacimiento = null;
        try {
            nacimiento = fecha.parse("16-07-1981");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Alumno alumno = new Alumno("Juan", "Perez", nacimiento, "3456545F");
        Academia academia = new Academia();
        academia.matricularAlumno("Juan", "Perez", nacimiento, "3456545F");
        System.out.println(alumno.toString());
        System.out.println("La edad de " + alumno.getNombre() + " es: " + alumno.getEdad());

        try {
            nacimiento = fecha.parse("15-07-1985");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Alumno alumno2 = new Alumno("Xose", "Martinez", nacimiento, "2123233D");
        academia.matricularAlumno("Xose", "Martinez", nacimiento, "2123233D");
        System.out.println(alumno2.toString());
        System.out.println("La edad de " + alumno2.getNombre() + " es: " + alumno2.getEdad());
        try {
            nacimiento = fecha.parse("16-08-1985");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Alumno alumno3 = new Alumno("Maria", "Lopez", nacimiento, "1235562121S");
        academia.matricularAlumno("Maria", "Lopez", nacimiento, "1235562121S");
        System.out.println(alumno3.toString());
        System.out.println("La edad de " + alumno3.getNombre() + " es: " + alumno3.getEdad());

        Scanner leer = new Scanner(System.in);

        System.out.println("Elige opción: \n" +
                "1. Crear alumno \n" +
                "2. Mostrar alumno \n" +
                "10. Salir");
        int opcion = leer.nextInt();
        leer.nextLine();
        boolean salir=false;
        do {
        switch(opcion) {
            case 1:
                System.out.println("Introduzca nombre");
                String nombre= leer.nextLine();
                System.out.println("Introduzca apellido");
                String apellido= leer.nextLine();
                System.out.println("Introduzca fecha de nacimiento(dd-mm-yyyy)");
                String fechaNacimiento=leer.nextLine();
                try {
                    nacimiento = fecha.parse(fechaNacimiento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("Introduzca DNI");
                String dni= leer.nextLine();
                academia.matricularAlumno(nombre,apellido,nacimiento,dni);
                break;
            case 2:
                break;
            case 10:
                salir=true;
                break;
            default:
                System.out.println("Opción no valida");
                leer.nextLine();
               opcion=leer.nextInt();
                break;
        }
        }while(salir==false);
    }
}

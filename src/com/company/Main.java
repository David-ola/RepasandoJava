package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Date nacimiento = null;
        nacimiento = convertirFecha("16-07-1981");
        Alumno alumno = new Alumno("Juan", "Perez", nacimiento, "3456545F");
        Academia academia = new Academia();
        academia.matricularAlumno("Juan", "Perez", nacimiento, "3456545F");
        System.out.println("La edad de " + alumno.getNombre() + " es: " + alumno.getEdad());
        nacimiento = convertirFecha("15-07-1985");
        Alumno alumno2 = new Alumno("Xose", "Martinez", nacimiento, "2123233D");
        academia.matricularAlumno("Xose", "Martinez", nacimiento, "2123233D");
        System.out.println("La edad de " + alumno2.getNombre() + " es: " + alumno2.getEdad());
        nacimiento = convertirFecha("16-08-1985");
        Alumno alumno3 = new Alumno("Maria", "Lopez", nacimiento, "1235562121S");
        academia.matricularAlumno("Maria", "Lopez", nacimiento, "1235562121S");
        System.out.println("La edad de " + alumno3.getNombre() + " es: " + alumno3.getEdad());

        Scanner leer = new Scanner(System.in);



        boolean salir=false;
        do {
            System.out.println("Elige opción: \n" +
                "1. Crear alumno \n" +
                "2. Mostrar alumnos \n" +
                    "3.Buscar por DNI \n" +
                "10. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();
        switch(opcion) {
            case 1:
                System.out.println("Introduzca nombre");
                String nombre= leer.nextLine();
                System.out.println("Introduzca apellido");
                String apellido= leer.nextLine();
                System.out.println("Introduzca fecha de nacimiento(dd-mm-yyyy)");
                String fechaNacimiento=leer.nextLine();
                nacimiento = convertirFecha(fechaNacimiento);
                System.out.println("Introduzca DNI");
                String dni= leer.nextLine();
                academia.matricularAlumno(nombre,apellido,nacimiento,dni);
                System.out.println("Alumno creado");
                break;
            case 2:
                System.out.println(academia.mostrarAlumnos());
                break;
            case 3:
                System.out.println("Introduzca DNI");
                String dniBusqueda=leer.nextLine();
                System.out.println(academia.buscarDNI(dniBusqueda));
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

    private static Date convertirFecha(String fecha){
        SimpleDateFormat fecha1 = new SimpleDateFormat("dd-MM-yyyy");
        Date nacimiento = null;
        try {
            nacimiento = fecha1.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nacimiento;
    }
}

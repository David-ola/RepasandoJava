package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean seguir = true;
        Academia academia=new Academia();
        do {
            System.out.println("Elige una opcion: \n" +
                    "1. Crear alumno  \n" +
                    "2. Mostrar alumno \n" +
                    "3. Buscar alumno por DNI"
            );
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
crearAlumno(academia,leer);
                    break;
                case 2:
                    System.out.println(academia.showAllAlumnos());
                    break;
                case 3:
                    System.out.println("Introduzca DNI");
                    String dniBuscar=leer.nextLine();
                    System.out.println(academia.buscarAlumno(dniBuscar));
                    break;
                case 10:
                    seguir = false;
                default:
                    break;
            }
        } while (seguir==true);


        }

    private static void crearAlumno(Academia academia, Scanner leer) {
        System.out.println("Nombre: ");
        String nombre=leer.nextLine();
        System.out.println("Apellidos: ");
        String apellidos=leer.nextLine();
        System.out.println("Fecha de nacimiento: ");
        String fechaNacimiento=leer.nextLine();
        System.out.println("DNI: ");
        String dni=leer.nextLine();

        academia.addAlumno(nombre,apellidos,convertirFecha(fechaNacimiento),dni);
    }

    private static Date convertirFecha(String fecha){
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento=null;
        try {
            fechaNacimiento = objSDF.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  fechaNacimiento;
    }


    }












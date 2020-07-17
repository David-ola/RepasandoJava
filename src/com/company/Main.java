package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;
import com.company.bd.Conexion;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection conn= Conexion.getConn();

        //SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
        //Date fechaNacimiento = null;
        //try {
            //echaNacimiento = objSDF.parse("16-07-1981");
       // } catch (ParseException e) {
           // e.printStackTrace();
        //}

        //Alumno alumno = new Alumno("Juan", "Perez", fechaNacimiento, "3456545F");
        //System.out.println(alumno.toString());
        //System.out.println("La edad de " + alumno.getNombre() + " es: " + alumno.getEdad2());

        Scanner leer = new Scanner(System.in);
        boolean seguir = true;
        Academia academia = new Academia();
        do {
            System.out.println("Elige una opcion: \n" +
                    "1. Crear alumno \n" +
                    "2. Mostrar alumnos \n" +
                    "3. Buscar alumno por DNI \n" +
                    "4. Guardar datos \n" +
                    "5. Cargar Datos \n " +
                    "10. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    crearAlumno(academia, leer);
                    break;
                case 2:
                    System.out.println(academia.showAllAlumnos());
                    break;
                case 3:
                    buscarAlumnoPorDNI(academia,leer);
                    break;
                case 4:
                    academia.guardarDatos();
                    break;
                case 5:
                    academia.cargarDatos();
                    break;
                case 10:
                    seguir = false;
                default:
                    break;
            }

        } while (seguir == true);
    }


    private static void buscarAlumnoPorDNI(Academia academia, Scanner leer) {
        System.out.println("DNI alumno a buscar: ");
        String dni=leer.nextLine();
        System.out.println(academia.buscarAlumnoPorDNI(dni));
    }



    private static void crearAlumno(Academia academia, Scanner leer) {
        System.out.println("Nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = leer.nextLine();
        System.out.println("Fecha de nacimiento: ");
        String fechaNacimiento = leer.nextLine();
        System.out.println("DNI: ");
        String dni = leer.nextLine();

        academia.addAlumno(nombre, apellidos, convertirFecha(fechaNacimiento) , dni);
    }


    private static Date convertirFecha(String fecha) {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = objSDF.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaNacimiento;

    }

}

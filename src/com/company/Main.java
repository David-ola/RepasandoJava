package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;
import com.company.bd.Conexion;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection conn= Conexion.getConn();
        Date nacimiento = null;
        Academia academia = new Academia();
        Scanner leer = new Scanner(System.in);
        boolean salir=false;
        academia.cargarDatos();
        do {
            System.out.println("Elige opción: \n" +
                "1. Crear alumno \n" +
                "2. Mostrar alumnos \n" +
                    "3.Buscar por DNI \n" +
                    "4. \n" +
                    "5.Eliminar alumno \n" +
                    "6.Modificar alumno \n" +
                "10. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();
        switch(opcion) {
            case 1:
                System.out.println("Introduzca nombre");
                String nombre= leer.nextLine();
                System.out.println("Introduzca direccion");
                String direccion= leer.nextLine();
                System.out.println("Introduzca fecha de nacimiento(dd-mm-yyyy)");
                String fechaNacimiento=leer.nextLine();
                nacimiento = convertirFecha(fechaNacimiento);
                System.out.println("Introduzca DNI");
                String dni= leer.nextLine();
                academia.crearAlumno(nombre,direccion,nacimiento,dni);
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
            case 4:

                break;
            case 5:
                System.out.println("Inserte dni del alumno a eliminar");
                String dniEliminar=leer.nextLine();
                academia.eliminarAlumno(dniEliminar);
                System.out.println("Alumno eliminado");
                break;
            case 6:
                System.out.println("Inserte dni del alumno a modificar");
                String dniMod=leer.nextLine();
                System.out.println("Elija que modificar: \n" +
                        "1-Nombre \n" +
                        "2-Calle \n" +
                        "3-DNI \n" +
                        "4-Fecha");
                int opt=leer.nextInt();
                leer.nextLine();
                switch (opt){
                    case 1:
                        System.out.println("Introduzca nuevo nombre");
                        String nombreMod=leer.nextLine();
                        academia.modificarNombre(dniMod,nombreMod);
                        break;
                    case 2:
                        System.out.println("Introduzca nueva calle");
                        String calleMod=leer.nextLine();
                        academia.modificarCalle(dniMod,calleMod);
                        break;
                    case 3:
                        System.out.println("Introduzca nuevo DNI");
                        String dniNuevo=leer.nextLine();
                        academia.modificarDni(dniMod,dniNuevo);
                        break;
                    case 4:
                        System.out.println("Introduzca nueva fecha (dd-mm-yyyy)");
                        String fechaMod=leer.nextLine();
                        nacimiento = convertirFecha(fechaMod);
                        academia.modificarFecha(dniMod,nacimiento);
                        break;
                    default: break;
                }
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

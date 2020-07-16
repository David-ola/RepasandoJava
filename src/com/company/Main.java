package com.company;

import com.company.Modelos.Academia;
import com.company.Modelos.Alumno;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento=null;
        try {
           fechaNacimiento = objSDF.parse("16-07-1981");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Alumno alumno=new Alumno("Juan","Perez",fechaNacimiento,"3456545F");
        System.out.println(alumno.toString());
        System.out.println("La edad de "+alumno.getNombre()+ " es: "+alumno.getEdad2());

        Scanner leer = new Scanner(System.in);
        boolean seguir=true;
        Academia academia=new Academia();
        do {
            System.out.println("Elige una opción: \n" +
                    "1.  Crear alumno \n" +
                    "2.  Mostrar alumno\n" +
                    "10. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    crearAlumno(academia,leer);
                    break;
                case 2:
                    break;
                case 10:
                    seguir=false;
                default:
                    break;

            }
        }while (seguir==true);

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

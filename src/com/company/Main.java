package com.company;

import com.company.Modelos.Alumno;

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
        do {
            System.out.println("Elige una opción: \n" +
                    "1. Crear alumno \n" +
                    "2. Mostrar alumno\n" +
                    "10. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
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
}

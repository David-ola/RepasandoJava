package com.company.Modelos;

import java.util.Calendar;
import java.util.Date;

public class Alumno {
    private String nombre;
    private String apellidos;
    private Date nacimiento;
    private String dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Alumno(String nombre, String apellidos, Date nacimiento, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "nombre:'" + nombre + '\'' +
                ", apellidos:'" + apellidos + '\'' +
                ", nacimiento:" + nacimiento +
                ", dni:'" + dni +"'";
    }

    public int getEdad() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.nacimiento);
        Date actual = new Date();
        Calendar calenActu = Calendar.getInstance();
        calenActu.setTime(actual);

        if ((calendar.get(Calendar.MONTH)) > calenActu.get(Calendar.MONTH) ) /*No ha cumplido */{
            int edad = calenActu.get(Calendar.YEAR) - (calendar.get(Calendar.YEAR)) -1 ;
            return edad;
        } else if(calenActu.get(Calendar.MONTH) == (calendar.get(Calendar.MONTH)))/*No se sabe */{
            if ( calenActu.get(Calendar.DAY_OF_MONTH) < (calendar.get(Calendar.DAY_OF_MONTH)))/*No ha cumplido */ {
                int edad = calenActu.get(Calendar.YEAR) - (calendar.get(Calendar.YEAR)) - 1;
                return edad;
            }else {
                int edad = calenActu.get(Calendar.YEAR) - (calendar.get(Calendar.YEAR))/*Si cumplió */;
                return edad;
            }
        }else {
            int edad = calenActu.get(Calendar.YEAR) - (calendar.get(Calendar.YEAR)) /* Si cumplió*/;
            return edad;
        }
    }
}
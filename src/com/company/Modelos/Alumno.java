package com.company.Modelos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Alumno {
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String dni;

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dni='" + dni + '\'' +
                '}';
    }

    public Alumno(String nombre, String apellidos, Date fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        String edadS=simpleDateFormat.format(fechaNacimiento);
        int edad=Integer.parseInt(simpleDateFormat.format(new Date()))-Integer.parseInt(edadS);
        return edad;
    }

    public int getEdad2(){
        Calendar today = Calendar.getInstance();
        Calendar c = new GregorianCalendar();
        c.setTime(this.fechaNacimiento);
        int diffYear = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int diffMonth =today.get(Calendar.MONTH) - c.get(Calendar.MONTH);
        int diffDays=today.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
        if(diffMonth<0) diffYear-=1;
        if(diffMonth==0)
            if(diffDays<0) diffYear-=1;

        return diffYear;
    }

    public String setNombre(){
        return nombre;
    }
}

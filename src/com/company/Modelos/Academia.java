package com.company.Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Academia {

    private List<Alumno> alumnos;

    public Academia(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Academia() {
        this.alumnos = new ArrayList<>();
    }

    public void crearAlumno(String nombre, String apellidos, Date fechaNacimiento, String dni) {

        this.alumnos.add(new Alumno(nombre, apellidos, fechaNacimiento, dni));
    }

    public List<String> mostrarAlumnos() {
        List<String> n = new ArrayList<>();
        this.alumnos.forEach(alumno -> {
            n.add(alumno.getNombre() + " " + alumno.getApellidos() + " " + alumno.getFechaNacimiento() + " " + alumno.getDni());
        });
    }
}
package com.company.Modelos;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Alumno> alumnoList;

    public Academia() {
        alumnoList=new ArrayList<>();
    }
    public void  addAlumno(String nombre, String apellidos, Date fechaNacimiento, String dni){
        this.alumnoList.add(new Alumno(nombre, apellidos, fechaNacimiento, dni));
    }




}

package com.company.Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Academia {
    private List<Alumno> alumnoList;

    public Academia() {
        alumnoList=new ArrayList<>();
    }
    public void addAlumno(String nombre, String apellido, Date fechaNac, String DNI){
        this.alumnoList.add(new Alumno(nombre,apellido,fechaNac,DNI));
    }
}

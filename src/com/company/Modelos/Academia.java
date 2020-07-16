package com.company.Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Academia {
    private List<Alumno> listaAlumnos;
    public Academia(){
       listaAlumnos=new ArrayList<>();
    }





        public void addAlumno(String nombre, String apellidos, Date fecha_nacimiento, String dni) {

            listaAlumnos.add(new Alumno(nombre, apellidos, fecha_nacimiento,dni));
    }

    public String showAllAlumnos(){
        String texto="";
        for (int i = 0; i < listaAlumnos.size() ; i++) {
            texto+=listaAlumnos.get(i).toString();

        }
        return texto;
    }
}

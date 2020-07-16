package com.company.Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Academia {
    private List<Alumno> academia;

        public Academia() {
            this.academia =new ArrayList<>();
        }

        public int numeroAlumnos(){
            return this.academia.size();
        }

        public void matricularAlumno(String nombre,String apellido,Date nacimiento,String dni){
            this.academia.add(new Alumno(nombre,apellido,nacimiento,dni));
        }

        public List<String> mostrarAlumnos() {
            List<String> n = new ArrayList<>();
            this.academia.forEach(alumno->{
                System.out.println(alumno.toString());
                System.out.println(alumno.getNombre());
                n.add(alumno.getNombre() + " "+ alumno.getApellidos() +" "+alumno.getNacimiento()+" "+alumno.getDni()+"\n");
            });
            return n;
        }
    }


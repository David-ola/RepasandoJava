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

        public String mostrarAlumnos() {
            String lista ="";
            for (int i = 0; i <academia.size() ; i++) {
                lista+= academia.get(i).toString();
                lista+= "\n";
            }
            return lista;
        /*    this.academia.forEach(alumno->{
                lista+=alumno.toString();
                n.add(alumno.toString());
            });
            return n; */
        }
    }


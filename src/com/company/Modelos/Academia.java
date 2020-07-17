package com.company.Modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

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

    public String buscarAlumno(String dniBuscar) {
        for (int i = 0; i <listaAlumnos.size() ; i++) {
            if(listaAlumnos.get(i).getDni().equals(dniBuscar)){
                return listaAlumnos.get(i).toString();
            }

        }
return "El alumno no esta en la academia";
    }
}

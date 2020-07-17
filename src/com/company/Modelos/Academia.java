package com.company.Modelos;

import com.company.bd.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            listaAlumnos.add(new Alumno(nombre,apellidos,fecha_nacimiento,dni));
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
    public void guardarDatos(){
        Connection conexion= Conexion.getConexion();
        String consulta ="select * from alumnos where dni=?";
        PreparedStatement sentencia=null;
        for (int i = 0; i <listaAlumnos.size() ; i++) {

            try {
                 sentencia = conexion.prepareStatement(consulta);
                 sentencia.setString(1,listaAlumnos.get(i).getDni());
                ResultSet resultado= sentencia.executeQuery();
                if(resultado.next()){
                    //El alumno existe

                }else{
                    //El alumno no existe
                    crearAlumno(listaAlumnos.get(i));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void crearAlumno(Alumno alumno) {
        Connection conexion= Conexion.getConexion();
        String consulta="Insert into alumnos (nombre, apellidos,fecha_nac, dni) values (?,?,?,?)";
        try {
            PreparedStatement sentencia=conexion.prepareStatement(consulta);
            sentencia.setString(1,alumno.getNombre());
            sentencia.setString(2,alumno.getApellidos());
          java.sql.Date fechaSQL=new java.sql.Date(alumno.getFechaNacimiento().getTime());
          sentencia.setDate(3,fechaSQL);
            sentencia.setString(4,alumno.getDni());
            sentencia.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void cargarDatos(){
        listaAlumnos.clear();//vaciar lista actual
        Connection conexion=Conexion.getConexion();
        String consulta="select nombre,apellidos,fecha_nac,dni from alumnos";
        try {
            PreparedStatement sentencia=conexion.prepareStatement(consulta);
            ResultSet rs=sentencia.executeQuery();
            while (rs.next()) {
                String nombre= rs.getString(1);
                String apellidos= rs.getString(2);
                Date fecha_nac= rs.getDate(3);
                String dni= rs.getString(4);
                listaAlumnos.add(new Alumno(nombre,apellidos,fecha_nac,dni));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

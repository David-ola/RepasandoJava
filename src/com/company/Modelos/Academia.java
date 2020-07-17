package com.company.Modelos;

import com.company.bd.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public String showAllAlumnos(){
        String texto="";
        for (int i = 0; i < alumnoList.size() ; i++) {
            texto+=alumnoList.get(i).toString();
        }
        return texto;
    }
    public String buscarAlumnoPorDNI(String dni){
        for (int i = 0; i < alumnoList.size() ; i++) {
            if(alumnoList.get(i).getDni().equals(dni)){
                return alumnoList.get(i).toString();
            }
        }
        return "El alumno no esta en la academia";
    }
    public void guardarDatos(){
        Connection conn= Conexion.getConn();
        String consulta="select * from alumnos where dni=?";
        PreparedStatement sentencia=null;
        for (int i = 0; i < alumnoList.size(); i++) {

            try {
                sentencia=conn.prepareStatement(consulta);
                sentencia.setString(1,alumnoList.get(i).getDni());
                ResultSet resultado=sentencia.executeQuery();
                if(resultado.next()){
                    //El alumno existe
                    actualizarAlumno(alumnoList.get(i));
                }else{
                    //El alumno no exite
                    crearAlumno(alumnoList.get(i));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



    }

    private void actualizarAlumno(Alumno alumno) {
        Connection conn=Conexion.getConn();
        String consulta="UPDATE ALUMNOS SET nombre=?,apellidos=?,fecha_nac=? WHERE dni=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,alumno.getNombre());
            sentencia.setString(2,alumno.getApellidos());
            java.sql.Date fechaSQL=new  java.sql.Date(alumno.getFechaNacimiento().getTime());
            sentencia.setDate(3, fechaSQL);
            sentencia.setString(4,alumno.getDni());
            sentencia.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void crearAlumno(Alumno alumno) {
        Connection conn=Conexion.getConn();
        String consulta="INSERT INTO ALUMNOS (nombre,apellidos,fecha_nac,dni,created_at) " +
                "values (?,?,?,?,now())";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,alumno.getNombre());
            sentencia.setString(2,alumno.getApellidos());
            java.sql.Date fechaSQL=new  java.sql.Date(alumno.getFechaNacimiento().getTime());
            sentencia.setDate(3, fechaSQL);
            sentencia.setString(4,alumno.getDni());
            sentencia.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cargarDatos() {
        alumnoList.clear(); //Vaciamos la lista actual
        Connection conn=Conexion.getConn();
        String consulta="select nombre,apellidos,fecha_nac,dni from alumnos";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            ResultSet rs=sentencia.executeQuery();
            while (rs.next()){
                String nombre= rs.getString(1);
                String apellidos=rs.getString(2);
                Date fecha_nac=rs.getDate(3);
                String dni=rs.getString(4);
                alumnoList.add(new Alumno(nombre,apellidos,fecha_nac,dni));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

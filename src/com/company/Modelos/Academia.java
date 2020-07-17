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
    private List<Alumno> academia;

        public Academia() {
            this.academia =new ArrayList<>();
        }

        public int numeroAlumnos(){
            return this.academia.size();
        }

        public void matricularAlumno(String nombre,String direccion,Date nacimiento,String dni){
            this.academia.add(new Alumno(nombre,direccion,nacimiento,dni));
        }

        public String mostrarAlumnos() {
            String lista ="";
            for (int i = 0; i <academia.size() ; i++) {
                lista+= academia.get(i).toString();
                lista+= "\n";
            }
            return lista;
        }

    public String buscarDNI(String dniBusqueda) {
        for (int i = 0; i < academia.size(); i++) {
            if (academia.get(i).getDni().equals(dniBusqueda)) {
                return academia.get(i).toString();
            }

        }return "No se ha encontrado tal DNI en la lista";
    }

    private void actualizarAlumno(String nombre,String direccion,Date nacimiento,String dni) {
            Connection conn= Conexion.getConn();
            String consulta= "update alumnos set Nombre=? , Direccion=? , Nacimiento=? where DNI=?";
        try {
            PreparedStatement sentencia= conn.prepareStatement(consulta);
            sentencia.setString(1,nombre);
            sentencia.setString(2,direccion);
            java.sql.Date fechaSQL=new  java.sql.Date(nacimiento.getTime());
            sentencia.setDate(3, fechaSQL);
            sentencia.setString(4,dni);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearAlumno(String nombre, String direccion, Date nacimiento, String dni) {
        Connection conn= Conexion.getConn();
        String consulta="select * from alumnos where dni= ? ";
        PreparedStatement sentencia=null;
        try {
            sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,dni);
            ResultSet rs= sentencia.executeQuery();
            if (rs.next()){
                actualizarAlumno(nombre,direccion,nacimiento,dni);
            }else{
               String consulta2="insert into alumnos (Nombre,Direccion,DNI,Nacimiento) values(?,?,?,?)";
                    sentencia = conn.prepareStatement(consulta2);
                    sentencia.setString(1,nombre);
                    sentencia.setString(2,direccion);
                    sentencia.setString(3,dni);
                    java.sql.Date fechaSQL=new  java.sql.Date(nacimiento.getTime());
                    sentencia.setDate(4, fechaSQL);
                    sentencia.execute();
                this.academia.add(new Alumno(nombre,direccion,
                        nacimiento,dni));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAlumno(String dniEliminar) {
            Connection conn= Conexion.getConn();
            String consulta= "delete from alumnos where DNI=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,dniEliminar);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cargarDatos(){
            Connection conn=Conexion.getConn();
            String consulta= "select* from alumnos";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            ResultSet rs=sentencia.executeQuery();
            while (rs.next()){
                this.academia.add(new Alumno(rs.getString(1),rs.getString(2),
                        rs.getDate(5),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarNombre(String dniMod, String nombreMod) {
            Connection conn=Conexion.getConn();
            String consulta= "update alumnos set Nombre=? where DNI=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,nombreMod);
            sentencia.setString(2,dniMod);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarCalle(String dniMod, String calleMod) {
        Connection conn=Conexion.getConn();
        String consulta= "update alumnos set Direccion=? where DNI=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,calleMod);
            sentencia.setString(2,dniMod);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarDni(String dniMod, String dniNuevo) {
        Connection conn=Conexion.getConn();
        String consulta= "update alumnos set DNI=? where DNI=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            sentencia.setString(1,dniNuevo);
            sentencia.setString(2,dniMod);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarFecha(String dniMod, Date nacimiento) {
        Connection conn=Conexion.getConn();
        String consulta= "update alumnos set Nacimiento=? where DNI=?";
        try {
            PreparedStatement sentencia=conn.prepareStatement(consulta);
            java.sql.Date fechaSQL=new  java.sql.Date(nacimiento.getTime());
            sentencia.setDate(1,fechaSQL);
            sentencia.setString(2,dniMod);
            sentencia.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


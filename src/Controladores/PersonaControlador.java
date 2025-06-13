/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.DatabaseConnection;
import Interface.IGestorDatos;
import Modelos.Persona;
import com.sun.jdi.connect.spi.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class PersonaControlador implements IGestorDatos<Persona>{
    
    private Connection cnn;
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    
    @Override
    public void creacion(Persona objecto) {
        
        try {
            db.getConnection();
            String sql = "INSERT INTO persona (Nombre,Apellido,Correo,Fecha_nacimientro,Pais,Profesion,rol_id)" +"VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setString(1, objecto.getNombre());
            st.setString(2, objecto.getApellido());
            st.setString(3, objecto.getCorreo());
            java.sql.Date fechaNacimiento = new java.sql.Date(objecto.getFecha_nacimiento().getTime());
            st.setDate(4, fechaNacimiento);
            st.setString(5, objecto.getPais());
            st.setString(6, objecto.getProfesion());
            st.setInt(7, objecto.getRol_id());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha realizado un nuevo registro.", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor comprueba los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public Persona lectura(int id) {
        String sql = "SELECT Nombre,Apellido,Correo,Fecha_nacimientro,Pais,Profesion,rol_id FROM Persona WHERE id = ?";
        Persona personaTraida = new Persona();
        try {
            db.getConnection();
            PreparedStatement realizaConsulta = db.getConnection().prepareStatement(sql);
            realizaConsulta.setInt(1, id);
            ResultSet resultado = realizaConsulta.executeQuery();
            
            if(resultado.next()){
            
            personaTraida.setNombre(resultado.getString("Nombre"));
            personaTraida.setApellido(resultado.getString("Apellido"));
            personaTraida.setCorreo(resultado.getString("Correo"));
            
            personaTraida.setFecha_nacimiento(resultado.getDate("Fecha_nacimientro"));
            
            personaTraida.setPais(resultado.getString("Pais"));
            personaTraida.setProfesion(resultado.getString("Profesion"));
            personaTraida.setRol_id(resultado.getInt("Rol_id"));
            
                
            }else{
            personaTraida = new Persona();
            JOptionPane.showMessageDialog(null, "No se encuentran datos.");
            }
        } catch (SQLException e) {
            
            System.out.println("Error de tipo: "+e);    
            System.out.println("Error en la clase: "+this.getClass().getName());
        }
        return personaTraida;
    }

    @Override
    public void actualizar(Persona objetoActualizar, int id) {
        String sqlActualizar= "Update persona set Nombre=?,Apellido=?,Correo=?,Fecha_nacimientro=?,Pais=?,Profesion=?,rol_id=? where id= '"+id+"'";
        
        try {
            db.getConnection();
            PreparedStatement editar = db.getConnection().prepareStatement(sqlActualizar);
            editar.setString(1, objetoActualizar.getNombre());
            editar.setString(2, objetoActualizar.getApellido());
            editar.setString(3, objetoActualizar.getCorreo());
            java.sql.Date Fecha_nacimiento = new java.sql.Date(objetoActualizar.getFecha_nacimiento().getTime());
            editar.setDate(4, Fecha_nacimiento);
            editar.setString(5, objetoActualizar.getPais());
            editar.setString(6, objetoActualizar.getProfesion());
            editar.setInt(7, objetoActualizar.getRol_id());
            editar.executeUpdate();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro de la persona."+e,"Error al ACTUALIZAR",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

    @Override
    public void eliminar(int id) {
        String eliminar = "DELETE from persona where id ='"+id+"'";
        try {
            db.getConnection();
            PreparedStatement eliminacion = db.getConnection().prepareStatement(eliminar);
            int filasAfectadas = eliminacion.executeUpdate();
            
            if(filasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Datos Eliminados");
            }else{
            JOptionPane.showMessageDialog(null, "No se encontraron datos a eliminar"); 
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e);
            
        }
    }
    
}

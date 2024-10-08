/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Sergio De León
 */
public class Conexion {
    public Connection conexionbd;
    public final String bd = "docentes";
    public final String urlconexion = String.format("jdbc:mysql://localhost:3306/examen", bd);
    public final String usuario = "root";
    public final String contra = "admin123";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionbd = DriverManager.getConnection(urlconexion, usuario, contra);
            JOptionPane.showMessageDialog(null,"Conexión exitosa...","Exito",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(HeadlessException | ClassNotFoundException | SQLException ex){
        System.out.println("Error..."+ex.getMessage());
        }
        }
    public void cerrar_conexion(){
    try{
    conexionbd.close();
    
    }
    catch (SQLException ex){
    System.out.println("Error..."+ex.getMessage());
    }
    }
}

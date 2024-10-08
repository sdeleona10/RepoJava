/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio De León
 */
public class Conexión {
    public Connection conexionbd;
    public final String bd = "db_empresa";
    public final String urlconexion = String.format("jdbc:mysql://localhost:3306/db_empresa", bd);
    public final String usuario = "usr_empresa";
    public final String contra = "Empres@123";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionbd = DriverManager.getConnection(urlconexion, usuario, contra);
            
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Sergio De León
 */
public class Conexión {
    private final String puerto = "3306";
    private final String bd ="db_empresa";
    private final String urlconexion= String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto, bd);
    private final String usuario = "root";
    private final String contra = "Admin@123";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    public Connection conexionBD;
    public void abrir_conexion(){
        try{
        Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlconexion,usuario, contra);
           
        System.out.println("Conexion exitosa");}
        catch(Exception ex){
            System.out.println("algo salio mal:("+ ex.getMessage());
        }
    }
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }
        catch(Exception ex){
            System.out.println("algo salio mal:("+ ex.getMessage());
        }
    }
    }
    
    

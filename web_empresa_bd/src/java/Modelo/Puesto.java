/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author Sergio De León
 */
public class Puesto {
    private int id_puesto;
    private String puesto;
    private Conexión cn;

    public Puesto() {
    }

    public Puesto(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public HashMap drop_sangre(){
    HashMap<String,String> drop = new HashMap();
    try{
        cn = new Conexión();
        String query = "SELECT ID_puesto as ID,Puesto FROM puestos;";
        cn.abrir_conexion();
        ResultSet consulta = cn.conexionbd.createStatement().executeQuery(query);
        while (consulta.next()){
        drop.put(consulta.getString("ID"), consulta.getString("Puesto"));
        }
        cn.cerrar_conexion();
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    return drop;
    }
}

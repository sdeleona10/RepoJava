/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; //insert sql
import java.sql.SQLException;
import java.sql.ResultSet;  //select sql
import javax.swing.table.DefaultTableModel;
/**
 * 
 *
 * @author Sergio De León
 */
public class Cliente extends Persona{
    private String nit;
    private int id;
    Conexión cn;

    public Cliente() {}
    public Cliente(int id,String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;    
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    cn = new Conexión();
    cn.abrir_conexion();
    String query;
    query = "Select id_Clientes as ID_Clientes, NIT, Nombres, Apellidos, Dirección, Teléfono, Fecha_nacimiento from clientes;";
    ResultSet consulta = cn.conexionbd.createStatement().executeQuery(query);
    
    String encabezado[] = {"ID", "NIT", "Nombre", "Apellido", "Dirección", "Teléfono", "Fecha nacimiento"};
    tabla.setColumnIdentifiers(encabezado);
    
    String datos[] = new String[7];
    while(consulta.next()){
    datos[0] = consulta.getString("ID_Clientes");
    datos[1] = consulta.getString("NIT");
    datos[2] = consulta.getString("Nombres");
    datos[3] = consulta.getString("Apellidos");
    datos[4] = consulta.getString("Dirección");
    datos[5] = consulta.getString("Teléfono");
    datos[6] = consulta.getString("Fecha_nacimiento");
    tabla.addRow(datos);
    }
    cn.cerrar_conexion();
    }
    catch(SQLException ex){
    cn.cerrar_conexion();
    System.out.println("Error..."+ex.getMessage());}
    return tabla;
    }
    @Override
    public void agregar(){
    try{
        PreparedStatement parametro;
        String query = "INSERT INTO clientes (NIT,Nombres,Apellidos,Dirección,Teléfono,Fecha_nacimiento) VALUES (?,?,?,?,?,?);";
        cn = new Conexión();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getFecha_nacimiento());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString (ejecutar) +" registro ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(HeadlessException | SQLException ex){
    System.out.println("Error..."+ex.getMessage());
    }
    }
    @Override
    public void modificar(){
    try{
        PreparedStatement parametro;
        String query = "UPDATE clientes SET NIT = ?,Nombres = ?,Apellidos = ?,Dirección = ?,Teléfono = ?,Fecha_nacimiento = ?"+ "WHERE ID_Clientes = ?";
        cn = new Conexión();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getFecha_nacimiento());
        parametro.setInt(7, this.getId());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString (ejecutar) +" registro actualizado","Actualizar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(HeadlessException | SQLException ex){
    System.out.println("Error..." + ex.getMessage());
    } 
    }
    
    @Override 
    public void eliminar(){
    try{
        PreparedStatement parametro;
        String query = "DELETE from clientes WHERE ID_Clientes = ?";
        cn = new Conexión();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setInt(1, this.getId());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString (ejecutar) +" registro eliminado","Eliminar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(HeadlessException | SQLException ex){
    System.out.println("Error..." + ex.getMessage());
    } 
    }
} 

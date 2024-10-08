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
 * @author Sergio De León
 */
public class Docente extends Persona{
    private String nit, escuela, ingreso;
    private float salario;
    Conexion cn;

    public Docente() {}

    public Docente(String nit, String escuela, String ingreso, float salario, String id, String nombres, String apellidos, String direccion, String telefono, String nacimiento) {
        super(id, nombres, apellidos, direccion, telefono, nacimiento);
        this.nit = nit;
        this.escuela = escuela;
        this.ingreso = ingreso;
        this.salario = salario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    cn = new Conexion();
    cn.abrir_conexion();
    String query;
    query = "Select ID as ID, nombres, apellidos, dirección, teléfono, nacimiento, nit, salario, escuela, fecha_ingreso from docente;";
    ResultSet consulta = cn.conexionbd.createStatement().executeQuery(query);
    
    String encabezado[] = {"ID", "Nombre", "Apellido", "Dirección", "Teléfono", "Fecha nacimiento", "NIT", "Salario", "Escuela", "Fecha ingreso"};
    tabla.setColumnIdentifiers(encabezado);
    
    String datos[] = new String[10];
    while(consulta.next()){
    datos[0] = consulta.getString("ID");
    datos[1] = consulta.getString("nombres");
    datos[2] = consulta.getString("apellidos");
    datos[3] = consulta.getString("direccion");
    datos[4] = consulta.getString("telefono");
    datos[5] = consulta.getString("nacimiento");
    datos[6] = consulta.getString("nit");
    datos[7] = consulta.getString("salario");
    datos[8] = consulta.getString("escuela");
    datos[9] = consulta.getString("fecha_ingreso");
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
    public void crear(){
    try{
        PreparedStatement parametro;
        String query = "INSERT INTO docente (NIT,Nombres,Apellidos,Dirección,Teléfono,Fecha_nacimiento) VALUES (?,?,?,?,?,?);";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getNacimiento());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString (ejecutar) +" registro ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(HeadlessException | SQLException ex){
    System.out.println("Error..."+ex.getMessage());
    }
    }
    @Override
    public void actualizar(){
    try{
        PreparedStatement parametro;
        String query = "UPDATE docente SET nombres = ?,apellidos = ?,direccion = ?,telefono = ?,nacimiento = ?, nit = ?, salario=?, escuela=?, fecha_ingreso=?"+ "WHERE ID = ?";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getNacimiento());
        parametro.setString(7, this.getId());
        
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
        String query = "DELETE from docente WHERE ID = ?";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionbd.prepareStatement(query);
        parametro.setString(1, this.getId());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString (ejecutar) +" registro eliminado","Eliminar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(HeadlessException | SQLException ex){
    System.out.println("Error..." + ex.getMessage());
    } 
    }
}

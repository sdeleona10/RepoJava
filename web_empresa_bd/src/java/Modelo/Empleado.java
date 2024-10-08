/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sergio De León
 */
public class Empleado extends Persona{
    private String codigo;
    private int id_puesto;
    private Conexión cn;
    
    public Empleado(){}

    public Empleado(String codigo, int id_puesto, int id, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(id, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo = codigo;
        this.id_puesto = id_puesto;
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
        cn = new Conexión();
        cn.abrir_conexion();
        String query = "SELECT e.ID_empleado, e.Código, e.Nombre, e.Apellido, e.Dirección, e.Teléfono, e.Fecha_nacimiento,p.Puesto, p.ID_puesto FROM empleados as e inner join puestos as p on e.ID_puesto = p.ID_puesto;";
        ResultSet consulta = cn.conexionbd.createStatement().executeQuery(query);
        String encabezado[] = {"ID", "Codigo", "Nombres", "Apellidos", "Direccion", "Telefono", "Nacimiento", "Puesto", "ID_Puesto"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[9];
        while (consulta.next()){
            datos[0] = consulta.getString("ID_empleado");
            datos[1] = consulta.getString("Código");
            datos[2] = consulta.getString("Nombre");
            datos[3] = consulta.getString("Apellido");
            datos[4] = consulta.getString("Dirección");
            datos[5] = consulta.getString("Teléfono");
            datos[6] = consulta.getString("Fecha_nacimiento");
            datos[7] = consulta.getString("Puesto");
            datos[8] = consulta.getString("ID_Puesto");
            tabla.addRow(datos);
        
        }
        
        
        cn.cerrar_conexion();
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
        return tabla;
    }
    @Override
    public int agregar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn= new Conexión();
            String query = "INSERT INTO empleados(Código,Nombre,Apellido,Dirección,Teléfono,Fecha_nacimiento,ID_puesto) VALUES(?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionbd.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFecha_nacimiento());
            parametro.setInt(7, this.getId_puesto());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    @Override
    public int modificar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn= new Conexión();
            String query = "UPDATE empleados set Código=?,Nombre=?,Apellido=?,Dirección=?,Teléfono=?,Fecha_nacimiento=?,ID_puesto=? where ID_empleado = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionbd.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFecha_nacimiento());
            parametro.setInt(7, getId_puesto());
            parametro.setInt(8, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    @Override
    public int eliminar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn= new Conexión();
            String query = "DELETE FROM empleados where ID_empleado = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionbd.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
}

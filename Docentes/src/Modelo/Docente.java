/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio De León
 */
public class Docente extends Persona{
    private String codigo_docente, fecha_ingreso, fecha_registro;
    private double salario;
    Conexión cn;
    public Docente() {}
   

    public String getCodigo_docente() {
        return codigo_docente;
    }

    public void setCodigo_docente(String codigo_docente) {
        this.codigo_docente = codigo_docente;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        String query = "INSERT INTO docentes (NIT,Nombres,Apellidos,Dirección,Teléfono,Fecha_nacimiento) VALUES (?,?,?,?,?,?);";
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

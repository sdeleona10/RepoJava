/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio De León
 */
public class Empleado extends Persona{
    private String codigo_empleado;
    private String puesto;

    public Empleado() {}
    public Empleado(String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
    }
    
    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    @Override
    public void agregar(){
    System.out.println("Codigo empleado: "+this.getCodigo_empleado());
    System.out.println("Nombre"+this.getPuesto());
    System.out.println("Nombre"+this.getNombres());
    System.out.println("Apellido"+this.getApellidos());
    System.out.println("Dirección"+this.getDireccion());
    System.out.println("Teléfono"+this.getTelefono());
    System.out.println("Fecha nacimiento"+this.getFecha_nacimiento());
    }
}

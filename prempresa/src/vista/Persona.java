/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Sergio De León
 */
public class Persona {
    //atributos
    private String nombres,apellidos,direccion,telefono,fecha_nacimiento;
    //constructor

    public Persona() {
    }
    

    public Persona(String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public String getNombres(){
    return nombres;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    //metodos crud
    protected String[] crear(){return null;}
    protected void leer(){}
    protected void actualizar(){}
    protected void borrar(){}
}


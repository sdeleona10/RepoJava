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
    private String codigo, sueldo, bono;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getSueldo() {
            return sueldo;
        }

        public void setSueldo(String sueldo) {
            this.sueldo = sueldo;
        }

        public String getBono() {
            return bono;
        }

        public void setBono(String bono) {
            this.bono = bono;
        }
        @Override
    public void agregar(){
    System.out.println("Codigo: "+this.getCodigo());
    System.out.println("Nombres: "+this.getNombres());
    System.out.println("Apellidos: "+getApellidos());
    System.out.println("Direccion: "+getDireccion());
    System.out.println("Telefono: "+getTelefono());
    System.out.println("Fecha nacimiento: "+this.getNacimiento());
    System.out.println("Sueldo: "+this.getSueldo());
    System.out.println("Bonificacion: "+this.getBono());
    }
}

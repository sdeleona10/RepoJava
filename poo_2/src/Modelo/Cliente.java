/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio De León
 */
public class Cliente extends Persona{
    private String nit;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    @Override
    public void agregar(){
    System.out.println("NIT: "+getNit());
    System.out.println("Nombres: "+getNombres());
    System.out.println("Apellidos: "+getApellidos());
    System.out.println("Direccion: "+getDireccion());
    System.out.println("Telefono: "+getTelefono());
    System.out.println("Fecha nacimiento: "+this.getFecha_nacimiento());
    }
}

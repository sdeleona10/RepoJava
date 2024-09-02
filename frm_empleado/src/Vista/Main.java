/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;
import Modelo.Conexión;
/**
 *
 * @author Sergio De León
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexión cn = new Conexión();
        cn.abrir_conexion();
        cn.cerrar_conexion();
       // frm_empleados frm = new frm_empleados();
       // frm.show();
    }
    
}


import com.dj.parcial.controlador.Con_Registro;
import com.dj.parcial.controlador.Con_Usuario;
import com.dj.parcial.modelos.Mod_Registro;
import com.dj.parcial.modelos.Mod_Usuario;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author davidjimenez
 */
public class Pruebas {
    public static void main(String[] args) {
        /*Mod_Usuario usuario = new Mod_Usuario();
        usuario.setNombre("Josue");
        usuario.setApellido("Jimenez");
        usuario.setFechaNacimiento("2022-11-26");
        usuario.setDomicilio("Loja");
        usuario.setCelular("0981188270");
        usuario.setUsername("josueJ");
        usuario.setPass("1234");*/
        
        Con_Usuario dao = new Con_Usuario();
        
        
        
        //con.agregarUser(usuario);
        /*for (Mod_Usuario u :dao.getTodos()) {
            System.out.println("nombre: "+u.getNombre());
            System.out.println("username: "+u.getUsername());
        }*/
        /*Mod_Usuario usuario = con.ingresoLogin("eddyA", "1234");
        Mod_Registro registro = new Mod_Registro();
        registro.setFecha(new Date());
        registro.setUsuario(usuario);
        
        Con_Registro dao2 = new Con_Registro(); 
        con2.addRegistro(registro);*/
        
        Mod_Usuario usuario = dao.ingresoLogin("josueJ", "1234");
        
        /*for (Mod_Registro r: usuario.getRegistros()) {
            System.out.println(r.getFecha());
        }*/
        
        for (Mod_Usuario u: dao.getTodos()) {
            System.out.println(u.getNombre());
        }
        
     
        System.out.println("Termino");
    }
}

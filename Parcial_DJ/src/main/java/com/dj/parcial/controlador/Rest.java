/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dj.parcial.controlador;

import com.dj.parcial.modelos.Mod_Registro;
import com.dj.parcial.modelos.Mod_Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author davidjimenez
 */
public class Rest {

    private static Con_Usuario ConU;
    private static Con_Registro ConR;

    public Rest() {
        ConU = new Con_Usuario();
        ConR = new Con_Registro();
    }

    public static int loginUsuario(Mod_Usuario usuario) {
        usuario = ConU.ingresoLogin(usuario.getUsername(), usuario.getPass());
        if (usuario != null) {
            Mod_Registro registro = new Mod_Registro();
            registro.setUsuario(usuario);
            registro.setFecha(new Date());
            ConR.addRegistro(registro);
        }
        int estado = usuario == null ? 0 : 1;
        return estado;
    }

    public static int agregarUsuario(Mod_Usuario u) {

        Mod_Usuario uExiste = ConU.verificarUser(u.getUsername());
        if (uExiste == null) {
            if (ConU.agregarUser(u)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }

    public static List<Mod_Registro> getRegistrosPorUsuario(String username) {
        List<Mod_Registro> registros = new ArrayList<>();
        Mod_Usuario usuario = ConU.verificarUser(username);
        if (usuario != null) 
            registros = usuario.getRegistros();
  
        return registros;
    }
    
    public static Mod_Usuario getUsuariosPorUsername(String username){
        Mod_Usuario usuario = ConU.verificarUser(username);
        return usuario;
    }
    
}

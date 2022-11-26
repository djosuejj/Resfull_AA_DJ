/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dj.parcial;

import com.google.gson.Gson;
import com.dj.parcial.controlador.Rest;
import com.dj.parcial.modelos.Mod_Registro;
import com.dj.parcial.modelos.Reg_Json;
import com.dj.parcial.modelos.Resul_Estado;
import com.dj.parcial.modelos.Mod_Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author davidjimenez
 */
public class Main {

    public final static String NAME_PERSISTENCE = "com.dj.par_jar_1.0-SNAPSHOTPU";

    public static void main(String[] args) {
        System.out.println("worl");
        new Rest();

        post("/login", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                System.out.println("Entrada: " + rqst.body());
                Mod_Usuario usuario = new Gson().fromJson(rqst.body(), Mod_Usuario.class);
                int estado = Rest.loginUsuario(usuario);
                Resul_Estado estadoObj = new Resul_Estado(estado);
                return new Gson().toJson(estadoObj);
            }
        });

        post("/nuevo", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                System.out.println("Entrada: " + rqst.body());
                Mod_Usuario usuario = new Gson().fromJson(rqst.body(), Mod_Usuario.class);
                int estado = Rest.agregarUsuario(usuario);
                Resul_Estado estadoObj = new Resul_Estado(estado);
                return new Gson().toJson(estadoObj);
            }
        });

        get("/registros", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                String param = rqst.queryParams("username");
                System.out.println("Parametro: " + param);
                List<Mod_Registro> lista = Rest.getRegistrosPorUsuario(param);
                List<Reg_Json> listaJson = new ArrayList<>();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm");
                for (Mod_Registro registro : lista) {
                    Reg_Json regJson = new Reg_Json();
                    regJson.setFecha(sdf.format(registro.getFecha()));
                    listaJson.add(regJson);
                }
                return new Gson().toJson(listaJson);
            }
        });
        
        get("/detalles", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                String param = rqst.queryParams("username");
                System.out.println("Parametro: " + param);
                Mod_Usuario usuario = Rest.getUsuariosPorUsername(param);
                usuario.setRegistros(null);
                return new Gson().toJson(usuario);
            }
        });
    }
}

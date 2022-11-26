/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dj.parcial.controlador;

import com.dj.parcial.Main;
import com.dj.parcial.modelos.Mod_Registro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author davidjimenez
 */
public class Con_Registro {
    public void addRegistro(Mod_Registro registro){
        try {
            EntityManagerFactory factory
                    = Persistence.createEntityManagerFactory(Main.NAME_PERSISTENCE);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(registro);
            em.getTransaction().commit();
            em.close();
            factory.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

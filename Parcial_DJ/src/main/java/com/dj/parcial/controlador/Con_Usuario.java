/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dj.parcial.controlador;

import com.dj.parcial.Main;
import com.dj.parcial.modelos.Mod_Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author davidjimenez
 */
public class Con_Usuario {

    public boolean agregarUser(Mod_Usuario usuario) {
        try {
            EntityManagerFactory factory
                    = Persistence.createEntityManagerFactory(Main.NAME_PERSISTENCE);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            em.close();
            factory.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Mod_Usuario> getTodos() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(Main.NAME_PERSISTENCE);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select u from Usuarios u");
        List<Mod_Usuario> lista = q.getResultList();
        em.close();
        factory.close();
        return lista;
    }

    public Mod_Usuario verificarUser(String username) {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(Main.NAME_PERSISTENCE);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select u from Usuarios u where u.username=:Usuario");
        q.setParameter("Usuario", username);
        Mod_Usuario usuario;
        try {
            usuario = (Mod_Usuario) q.setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        } finally {
            em.close();
            factory.close();
        }
        return usuario;
    }
    
    public Mod_Usuario ingresoLogin(String username, String pass){
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(Main.NAME_PERSISTENCE);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery
        ("select u from Usuarios u where u.username=:Usuario AND u.pass = :Pass");
        q.setParameter("Usuario", username);
        q.setParameter("Pass", pass);
        Mod_Usuario usuario;
        try {
            usuario = (Mod_Usuario) q.setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        } finally {
            em.close();
            factory.close();
        }
        return usuario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.UTS;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author frasc_000
 */
@Stateless
@Local(ExpedienteLocal.class)
public class ExpedienteEJB implements ExpedienteLocal {
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public void insertarExpediente(Expediente expediente) {
        em.persist(expediente);
    }

    @Override
    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano) {
//        System.out.println("EJB Expediente: "+expediente);
//        System.out.println("EJB Ciudadano: "+ciudadano);
        ciudadano.setExpediente(expediente);
        em.merge(ciudadano);
        //Esto da problemas si se descomenta
//        em.refresh(expediente);
//        em.refresh(ciudadano);
    }
    
    @Override
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano) {
        ciudadano.setExpediente(null);
        em.merge(ciudadano);
        em.refresh(expediente);
    }

    @Override
    public void modificarExpediente(Expediente expediente) {
        em.merge(expediente);
    }
    
    @Override
    public Expediente getExpediente(long id) {
        return em.find(Expediente.class, id);
    }
    
    @Override
    public void refrescarExpediente(Expediente expediente) {
        em.refresh(expediente);
    }
    
    @Override
    public List<Expediente> getExpedientes() {
        return em.createQuery("SELECT e FROM Expediente e").getResultList();
    }
    
    @Override
    public List<UTS> getUtss() {
        return em.createQuery("SELECT u FROM UTS u").getResultList();
    }
}

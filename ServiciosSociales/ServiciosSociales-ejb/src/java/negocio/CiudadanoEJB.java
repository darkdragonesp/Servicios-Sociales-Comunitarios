/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Ciudadano;
import entidades.Parentesco;
import entidades.ParentescoID;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author frasc_000
 */
@Stateless
@Local(CiudadanoLocal.class)
public class CiudadanoEJB implements CiudadanoLocal {
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;

    @Override
    public void insertarCiudadano(Ciudadano ciudadano) {
        em.persist(ciudadano.getPersona());
        em.persist(ciudadano);
    }

    @Override
    public void modificarCiudadano(Ciudadano ciudadano) {
        em.merge(ciudadano.getPersona());
        em.merge(ciudadano);
    }
    
    @Override
    public List<Ciudadano> getCiudadanos() {
        return em.createQuery("SELECT c FROM Ciudadano c").getResultList();
    }
    
    @Override
    public Ciudadano getCiudadano(String dni) {
//        System.out.println("EJB DNI: "+dni);
        Ciudadano ciudadano = em.find(Ciudadano.class, dni);
//        System.out.println("EJB Ciudadano: "+ciudadano);
        return ciudadano;
    }
    
    @Override
    public void insertarParentesco(Parentesco parentesco1, Parentesco parentesco2) {
        em.persist(parentesco1);
        em.persist(parentesco2);
//        em.refresh(parentesco1.getCiudadano1());
//        em.refresh(parentesco1.getCiudadano2());
    }
    
    @Override
    public void eliminarParentesco(Ciudadano ciudadano1, Ciudadano ciudadano2) {
        Parentesco parentesco = em.find(Parentesco.class, new ParentescoID(ciudadano1.getDni(), ciudadano2.getDni()));
        em.remove(parentesco);
        parentesco = em.find(Parentesco.class, new ParentescoID(ciudadano2.getDni(), ciudadano1.getDni()));
        em.remove(parentesco);
//        em.refresh(ciudadano1);
//        em.refresh(ciudadano2);
    }
    
    @Override
    public void eliminarParentesco(Parentesco parentesco) {
        Parentesco parentesco2 = em.find(Parentesco.class, new ParentescoID(parentesco.getParentescoPK().getCiudadanoDni2()
                                                                            , parentesco.getParentescoPK().getCiudadanoDni1()));
        em.remove(parentesco);
        em.remove(parentesco2);
    }
}

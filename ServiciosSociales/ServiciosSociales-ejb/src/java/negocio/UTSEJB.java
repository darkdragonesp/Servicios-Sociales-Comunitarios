/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.UTS;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DarkDragon
 */
@Stateless
public class UTSEJB implements UTSLocal {
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public boolean insertar(UTS uts) {
        if (uts == null) return false;
        try {
            em.persist(uts);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean eliminar(UTS uts) {
        if (uts == null) return false;
        try {
            em.remove(em.merge(uts));
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<UTS> getUTSs() {
        Query a;
         a=em.createQuery("SELECT DISTINCT a FROM UTS a  ORDER BY a.id", UTS.class);
        
         
         List<UTS> b= a.getResultList();
         
         System.out.println(b);
         return b;
    }
}
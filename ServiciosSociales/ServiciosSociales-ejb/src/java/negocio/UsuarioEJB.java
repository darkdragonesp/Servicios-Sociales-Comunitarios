/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package negocio;

import entidades.Persona;
import entidades.UTS;
import entidades.Usuario;
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
public class UsuarioEJB implements UsuarioLocal{
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public List<Usuario> getUsuarios() {
        return em.createQuery("SELECT a FROM Usuario a", Usuario.class).getResultList();
    }
    
    @Override
    public boolean insertar(Usuario u) {
        if (u == null) return false;
        try {
            em.persist(u);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean eliminar(Usuario u) {
        if (u == null) return false;
        try {
            String dni=u.getDni();
            em.remove(em.merge(u));
           
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean editar(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insertar(Persona u) {
        if (u == null) return false;
        try {
            em.persist(u);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    @Override
    public List<UTS> getUTSs() {
         return em.createQuery("SELECT a FROM UTS a", UTS.class).getResultList();
    }

    @Override
    public List<Persona> getPersonas() {
         return em.createQuery("SELECT a FROM Persona a", Persona.class).getResultList();
    }

    @Override
    public void eliminarP(Usuario selectedUsuario, String dni) {
        Query q = em.createQuery("SELECT p FROM Persona p WHERE p.dni = :d", Persona.class);
            q.setParameter("d", dni);
            Object p=q.getSingleResult();
            System.out.println(p);
            
            em.remove(em.merge(p));
    }
}

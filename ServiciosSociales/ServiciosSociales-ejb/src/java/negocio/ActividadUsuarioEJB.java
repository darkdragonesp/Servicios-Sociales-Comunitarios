/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidades.Actividad;
import entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Laura
 */
@Stateless
public class ActividadUsuarioEJB implements ActividadLocal{
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
         em.merge(usuario);
        
        return true;
    }
    @Override
    public boolean actualizarActividad(Actividad actividad){
        em.merge(actividad);
        return true;
    }
    @Override
    public boolean insertarActividad(Actividad actividad){
        em.persist(actividad);
        return true;
    }

    @Override
    public boolean borrarActividad(Actividad actividad){
        Actividad ac = em.find(Actividad.class, actividad.getId());
        em.remove(ac);
        return true;
    }
}

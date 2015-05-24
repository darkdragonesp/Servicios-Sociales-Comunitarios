/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package negocio;

import entidades.Persona;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
            //String dni= u.getDni();
            em.remove(em.merge(u));
            //em.remove(em.createQuery("SELECT a FROM Persona a WHERE UPPER(a.dni)==UPPER(dni)", Persona.class).getSingleResult());
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean editar(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

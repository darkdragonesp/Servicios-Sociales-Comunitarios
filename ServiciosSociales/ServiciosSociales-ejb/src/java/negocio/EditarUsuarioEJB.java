package negocio;

import entidades.Persona;
import entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Robin
 */
@Stateless
public class EditarUsuarioEJB implements EditarUsuarioLocal {

    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public boolean modificarP(Persona p){
        try{
            em.merge(p);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean insertar(Usuario user) {
        em.persist(user);
        return true;
    }

    @Override
    public boolean modificar(Usuario user) {
        try{
            em.merge(user);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(Usuario user) {
        em.remove(user);
        return true;
    }
}

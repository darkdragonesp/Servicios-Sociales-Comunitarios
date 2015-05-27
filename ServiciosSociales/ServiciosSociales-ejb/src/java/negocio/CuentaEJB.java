package negocio;

import entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuanJo
 */
@Stateless
public class CuentaEJB implements CuentaLocal {

    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    public Usuario refrescarUsuario(Usuario usuario) {
        Usuario user = em.find(Usuario.class, usuario.getDni());
        if(user == null)
            return null;
                    
        em.refresh(user);
        
        return user;
    }

    public boolean comprobarLogin() {
        return true;
    }
    
}

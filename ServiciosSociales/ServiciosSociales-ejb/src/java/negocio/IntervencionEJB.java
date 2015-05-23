package negocio;

import entidades.Intervencion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuanJo
 */
@Stateless
public class IntervencionEJB implements IntervencionLocal {
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    public boolean insertar(Intervencion intervencion) {
        em.persist(intervencion);
        
        return true;
    }

    public boolean modificar(Intervencion intervencion) {
        em.merge(intervencion);
        
        return true;
    }

    public boolean eliminar(Intervencion intervencion) {
        em.remove(intervencion);
        
        return true;
    }

}

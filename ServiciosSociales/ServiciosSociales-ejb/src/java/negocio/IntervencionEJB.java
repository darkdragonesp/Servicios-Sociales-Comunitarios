package negocio;

import entidades.Expediente;
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
        Expediente expediente = em.find(Expediente.class, intervencion.getExpediente().getId());
        em.persist(intervencion);
        expediente.getIntervenciones().add(intervencion);
        em.merge(expediente);
        
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

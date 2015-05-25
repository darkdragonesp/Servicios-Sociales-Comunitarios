package negocio;

import entidades.Expediente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuanJo
 */
@Stateless
public class ExpedienteEJB implements ExpedienteLocal {
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    public List<Expediente> getExpedientes(){
        return em.createQuery("SELECT exp FROM Expediente exp", Expediente.class).getResultList();
    }
    
    public boolean insertar(Expediente expediente) {
        em.persist(expediente);
        
        return true;
    }

    public boolean modificar(Expediente expediente) {
        em.merge(expediente);
        
        return true;
    }

    public boolean eliminar(Expediente expediente) {
        em.remove(expediente);
        
        return true;
    }
    
}

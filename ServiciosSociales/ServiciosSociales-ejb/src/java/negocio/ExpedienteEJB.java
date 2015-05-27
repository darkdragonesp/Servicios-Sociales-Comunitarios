package negocio;

import entidades.Expediente;
import entidades.Intervencion;
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
    
    @Override
    public List<Expediente> getExpedientes(){
        return em.createQuery("SELECT exp FROM Expediente exp", Expediente.class).getResultList();
    }
    
    @Override
    public List<Intervencion> getIntervenciones(){
        return em.createQuery("SELECT int FROM Intervencion int", Intervencion.class).getResultList();
    }
    
    @Override
    public Expediente refrescarExpediente(Expediente expediente){
        Expediente e = em.find(Expediente.class, expediente.getId());
        em.refresh(e);
        
        return e;
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

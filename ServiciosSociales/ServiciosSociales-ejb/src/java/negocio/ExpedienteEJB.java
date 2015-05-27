package negocio;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.Intervencion;
import entidades.UTS;
import java.util.List;
import javax.ejb.Local;
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
    
    @Override
    public Expediente refrescarExpediente(Expediente expediente){
        Expediente e = em.find(Expediente.class, expediente.getId());
        em.refresh(e);
        
        return e;
    }
    
    @Override
    public void insertarExpediente(Expediente expediente) {
        em.persist(expediente);
    }

    @Override
    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano) {
        ciudadano.setExpediente(expediente);
        em.merge(ciudadano);
    }
    
    @Override
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano) {
        ciudadano.setExpediente(null);
        em.merge(ciudadano);
        em.refresh(expediente);
    }

    @Override
    public void modificarExpediente(Expediente expediente) {
        em.merge(expediente);
    }
    
    @Override
    public Expediente getExpediente(long id) {
        return em.find(Expediente.class, id);
    }
    
    @Override
    public List<Expediente> getExpedientes() {
        return em.createQuery("SELECT e FROM Expediente e").getResultList();
    }
    
    @Override
    public List<Intervencion> getIntervenciones(){
        return em.createQuery("SELECT int FROM Intervencion int", Intervencion.class).getResultList();
    }
    
    @Override
    public List<UTS> getUtss() {
        return em.createQuery("SELECT u FROM UTS u").getResultList();
    }
}

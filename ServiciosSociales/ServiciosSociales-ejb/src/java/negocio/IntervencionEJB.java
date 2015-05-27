package negocio;

import entidades.Actividad;
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
    
    @Override
    public boolean insertar(Intervencion intervencion) {
        try{
            Expediente expediente = em.find(Expediente.class, intervencion.getExpediente().getId());
            Actividad actividad = em.find(Actividad.class, intervencion.getActividad().getId());
            
            em.persist(intervencion);
            
            expediente.getIntervenciones().add(intervencion);
            actividad.setIntervencion(intervencion);
            
            em.merge(actividad);
            em.merge(expediente);
            
        }catch(Exception e){
            return false;
        }  
        
        return true;
    }
    
    @Override
    public boolean modificar(Intervencion intervencion) {
        try{
            em.merge(intervencion);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean eliminar(Intervencion intervencion) {
        try{
            Intervencion in = em.find(Intervencion.class, intervencion.getId());
            Expediente expediente = in.getExpediente();
            expediente.getIntervenciones().remove(in);
            em.merge(expediente);
            em.remove(in);
        }catch(Exception e){
            System.out.println("e: "+e.getMessage());
            return false;
        }
        
        return true;
    }

}

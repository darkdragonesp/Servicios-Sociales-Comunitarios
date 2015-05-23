package beans;

import entidades.Expediente;
import entidades.Intervencion;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import negocio.IntervencionLocal;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "expedientes")
@SessionScoped
public class Expedientes implements Serializable{
    
    private Expediente expediente;
    private Intervencion intervencion;
    
    @EJB
    private IntervencionLocal negocioIntervencion;
    
    //@EJB
    //private ExpedienteLocal negocioExpediente;
    
    public Expedientes() {
    
    }
    
    //public 
    
}

package beans;

import entidades.Intervencion;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.IntervencionLocal;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "intervenciones")
@RequestScoped
public class Intervenciones {
    private Intervencion intervencion;
    
    @EJB
    private IntervencionLocal bd;
    
    public Intervenciones() {
    
    }
    
    public String insertar(){
        boolean estado = bd.insertar(intervencion);
        
        return "";
    }
    
    public String modificar(){
        return "";
    }
    
    public void eliminar(){
        
    }
    
}

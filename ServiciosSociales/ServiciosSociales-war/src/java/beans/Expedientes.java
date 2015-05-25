package beans;

import entidades.Expediente;
import entidades.Intervencion;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import negocio.ExpedienteLocal;
import negocio.IntervencionLocal;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "expedientes")
@ViewScoped
public class Expedientes implements Serializable{
    
    private Expediente expediente;
    private Expediente selectedExpediente;
    private Intervencion intervencion;
    
    @ManagedProperty(value = "#{controlAutorizacion}")
    private ControlAutorizacion sesion;
    
    @EJB
    private IntervencionLocal negocioIntervencion;
    
    @EJB
    private ExpedienteLocal negocioExpediente;
    
    public Expedientes() {
    
    }
    
    @PostConstruct
    public void init(){
        cargarExpediente();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String[] page = request.getRequestURI().split("/");
        //ystem.out.println(page[page.length-1]);
        if(page[page.length-1].equalsIgnoreCase("addIntervencion.xhtml")){
            intervencion = new Intervencion();
            intervencion.setId(idIntervencion());
            intervencion.setExpediente(expediente);
        }
        System.out.println("*****************************************************"
                + "*************************************************************************"
                + "**************************************************************************"
                + "**************************************************************************"+request.getRequestURI());
    }
    
    public void cargarExpediente(){
        expediente = sesion.getExpediente();
    }
    
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Intervencion getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(Intervencion intervencion) {
        this.intervencion = intervencion;
    }

    public void setSesion(ControlAutorizacion sesion) {
        this.sesion = sesion;
    }
    
    public String consultarExpediente(Expediente expediente){
        sesion.setExpediente(expediente);
        this.expediente = expediente;
        
        return "expediente.xhtml";
    }
    
    public String insertarExpediente(){
        boolean estado = negocioExpediente.insertar(expediente);
        
        return "expedientes.xhtml";
    }
    
    public String eliminarExpediente(Expediente expediente){
        boolean estado = negocioExpediente.eliminar(expediente);
        
        return "expedientes.xhtml";
    }
    
    public String insertarIntervencion(){
        intervencion.setExpediente(expediente);
        
        boolean estado = negocioIntervencion.insertar(intervencion);

        return "editar-expediente.xhtml";
    }
    
    public String eliminarIntervencion(){
        return "";
    }
    
    public void onRowSelect(SelectEvent event){
       selectedExpediente = (Expediente) event.getObject();
    }

    public Expediente getSelectedExpediente() {
        return selectedExpediente;
    }

    public void setSelectedExpediente(Expediente selectedExpediente) {
        this.selectedExpediente = selectedExpediente;
    }
    
    public long idIntervencion(){
        return expediente.getIntervenciones().size() + 1;
    }
    
}

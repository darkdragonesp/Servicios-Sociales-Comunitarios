package beans;

import entidades.Expediente;
import entidades.Intervencion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
        if(sesion.getExpediente() != null)
            cargarExpediente();
        if(sesion.getIntervencion() != null)
            cargarIntervencion();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String[] page = request.getRequestURI().split("/");

        if(page[page.length-1].equalsIgnoreCase("addIntervencion.xhtml")){
            intervencion = new Intervencion();
            //intervencion.setId(idIntervencion());
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
    
    public void cargarIntervencion(){
        intervencion = sesion.getIntervencion();
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
        System.out.println(expediente);
        //this.expediente = expediente;
        
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
        
        if(estado){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Intervención "+intervencion.getId()+" añadida"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        
        
        sesion.refrescarUsuario();
        
        if(sesion.isProfesional())
            return "expediente.xhtml";
        else
            return "editar-expediente.xhtml";
    }
    
    public String editarIntervencion(){
        Intervencion intervencion = sesion.getIntervencion();
        
        boolean estado = negocioIntervencion.modificar(intervencion);
        sesion.refrescarUsuario();
        sesion.setIntervencion(null); // se pone a null para evitar cargarIntervencion()
        
        return "editar-expediente.xhtml";
    }
    
    public String cancelarEditarIntervencion(){
        sesion.refrescarUsuario();
        if(sesion.isProfesional())
            return "expediente.xhtml";
        else
            return "editar-expediente.xhtml";
    }
    
    public void eliminarIntervencion(Intervencion intervencion){
        boolean estado = negocioIntervencion.eliminar(intervencion);
        if(estado){
            
        }else{
           System.out.println("Error"); 
        }

        sesion.refrescarUsuario();
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
        return sesion.getIntervenciones().size() + 1;
    }
    
    public List<String> listarNotas(String notas){
        List<String> l = new ArrayList<String>();
        return notas == null ? l : Arrays.asList(notas.split("\\|"));
    }
    
}

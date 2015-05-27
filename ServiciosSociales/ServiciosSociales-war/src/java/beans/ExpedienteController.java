package beans;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.Intervencion;
import entidades.Parentesco;
import entidades.UTS;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import negocio.CiudadanoLocal;
import negocio.ExpedienteLocal;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author FranciscoJosé
 */
@ManagedBean(name = "expedienteController")
@SessionScoped
public class ExpedienteController implements Serializable{
    private List<Expediente> expedientes;
    private List<Ciudadano> ciudadanos;
    private List<UTS> utss;
    private Expediente expediente = new Expediente();
    private Ciudadano ciudadano = new Ciudadano();
    private Ciudadano pariente = new Ciudadano();
    private String parentescoSeleccionado1;
    private String parentescoSeleccionado2;
    private Expediente selectedExpediente;
    
    @ManagedProperty(value="#{controlAutorizacion}")
    private ControlAutorizacion sesion;
    
    @EJB
    private ExpedienteLocal expedienteEJB;
    @EJB
    private CiudadanoLocal ciudadanoEJB;
    
    public ExpedienteController(){ 
        pariente = new Ciudadano();
        ciudadano = new Ciudadano();
    }

    public void setSesion(ControlAutorizacion sesion) {
        this.sesion = sesion;
    }
    
    public List<Expediente> getExpedientes() {
        this.expedientes = expedienteEJB.getExpedientes();
        return this.expedientes;
    }
    
    public List<Ciudadano> getCiudadanos() {
        this.ciudadanos = ciudadanoEJB.getCiudadanos();
        return this.ciudadanos;
    }

    public List<UTS> getUtss() {
        this.utss = expedienteEJB.getUtss();
        return utss;
    }
    
    public Expediente getExpediente() {
        return this.expediente;
    }
    
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public Ciudadano getPariente() {
        return pariente;
    }

    public void setPariente(Ciudadano pariente) {
        this.pariente = pariente;
    }

    public String getParentescoSeleccionado1() {
        return parentescoSeleccionado1;
    }

    public void setParentescoSeleccionado1(String parentescoSeleccionado1) {
        this.parentescoSeleccionado1 = parentescoSeleccionado1;
    }

    public String getParentescoSeleccionado2() {
        return parentescoSeleccionado2;
    }

    public void setParentescoSeleccionado2(String parentescoSeleccionado2) {
        this.parentescoSeleccionado2 = parentescoSeleccionado2;
    }

    public Expediente getSelectedExpediente() {
        return selectedExpediente;
    }

    public void setSelectedExpediente(Expediente selectedExpediente) {
        this.selectedExpediente = selectedExpediente;
        expediente = selectedExpediente;
    }
    
    public String verExpediente(Expediente expediente){
//        expedienteEJB.refrescarExpediente(expediente);
        this.expediente = expedienteEJB.getExpediente(expediente.getId());
        return "expediente.xhtml";
    }
    
    public String verCiudadano(String dni) {
        ciudadano = obtenerCiudadano(dni);
        return "ciudadano.xhtml";
    }
    
    public String verEditarCiudadano(String dni) {
        this.ciudadano = obtenerCiudadano(dni);
        return "editar-ciudadano.xhtml";
    }

    public Ciudadano obtenerCiudadano(String dni) {
//        System.out.println("MB DNI: "+dni);
        Ciudadano ciudadano = ciudadanoEJB.getCiudadano(dni);
//        System.out.println("MB Ciudadano: "+ciudadano);
        return ciudadano;
    }
    
    public String modificarCiudadano(Ciudadano ciudadano) {
        ciudadanoEJB.modificarCiudadano(ciudadano);
        return "ciudadano.xhtml";
    }
    
    public String modificarExpediente(Expediente expediente) {
        expedienteEJB.modificarExpediente(expediente);
        return "expediente.xhtml";
    }
    
    public String verAnadirCiudadano() {
        this.ciudadano = new Ciudadano();
        return "anadir-ciudadano.xhtml";
    }
    
    public String verAnadirExpediente() {
        this.expediente = new Expediente();
        return "anadir-expediente.xhtml";
    }
    
    public String crearCiudadano(Ciudadano ciudadano) {
        ciudadano.setExpediente(sesion.getExpediente());
        ciudadano.getPersona().setDni(ciudadano.getDni());
        ciudadanoEJB.insertarCiudadano(ciudadano);
        return "ciudadano.xhtml";
    }
    
    public String crearExpediente(Expediente expediente) {
        expedienteEJB.insertarExpediente(expediente);
        return "expediente.xhtml";
    }
    
    public void anadirCiudadano(Expediente expediente, String dni) {
//        Ciudadano ciudadano = obtenerCiudadano(dni);
//        ciudadano.setExpediente(expediente);
//        ciudadanoEJB.modificarCiudadano(ciudadano);
        
//        System.out.println("MB Expediente: "+expediente);
        Ciudadano ciudadano = obtenerCiudadano(dni);
//        System.out.println("MB Ciudadano: "+ciudadano);
        expedienteEJB.anadirCiudadano(expediente, ciudadano);
    }
    
//    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano) {
////        ciudadano.setExpediente(expediente);
////        ciudadanoEJB.modificarCiudadano(ciudadano);
//        System.out.println("MB Expediente: "+expediente);
//        System.out.println("MB Ciudadano: "+ciudadano);
//        expedienteEJB.anadirCiudadano(expediente, ciudadano);
//    }
    
    public void eliminarCiudadano(Expediente expediente, String dni) {
        Ciudadano ciudadano = obtenerCiudadano(dni);
//        System.out.println("MB Expediente: "+expediente);
//        System.out.println("MB Ciudadano: "+ciudadano);
        this.expedienteEJB.eliminarCiudadano(expediente, ciudadano);
    }
    
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano) {
        this.expedienteEJB.eliminarCiudadano(expediente, ciudadano);
    }
    
    public void eliminarIntervencion(Expediente expediente, Intervencion intervencion){
        long id = intervencion.getId();
        if(expediente.getIntervenciones().remove(intervencion)){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Intervención "+id+" eliminada"));
        }
    }
    
    public void anadirParentesco(Ciudadano ciudadano, Ciudadano pariente, String parentescoSeleccionado1, String parentescoSeleccionado2) {
        System.out.println("MB Ciudadano: "+ciudadano);
        System.out.println("MB Pariente: "+pariente);
        Parentesco parentesco1 = new Parentesco(ciudadano.getDni(), pariente.getDni(), parentescoSeleccionado1);
        Parentesco parentesco2 = new Parentesco(pariente.getDni(), ciudadano.getDni(), parentescoSeleccionado2);
        ciudadanoEJB.insertarParentesco(parentesco1, parentesco2);
        this.ciudadano = ciudadanoEJB.getCiudadano(this.ciudadano.getDni());
    }
    
    public void eliminarParentesco(Ciudadano ciudadano, Ciudadano pariente) {
//        pariente.getParentescos().remove(obtenerParentesco(pariente, ciudadano));
//        ciudadano.getParentescos().remove(obtenerParentesco(ciudadano, pariente));
        ciudadanoEJB.eliminarParentesco(ciudadano, pariente);
    }
    
    public String formatFecha(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        if(fecha == null)
            return "";
        return df.format(fecha);     
    }
    
    public void onRowSelect(SelectEvent event){
       selectedExpediente = (Expediente) event.getObject();
    }
}

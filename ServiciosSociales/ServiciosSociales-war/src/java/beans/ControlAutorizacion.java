package beans;

import entidades.Expediente;
import entidades.Intervencion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import entidades.Usuario;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import negocio.CuentaLocal;
import negocio.ExpedienteLocal;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable{
    private Usuario usuario;
    private Expediente expediente;
    private Intervencion intervencion;
    private int numtabs;
    
    @EJB
    private ExpedienteLocal negocioExpediente;
    
    @EJB
    private CuentaLocal cuenta;
    
    public ControlAutorizacion() {
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public int getNumtabs() {
        return numtabs;
    }

    public void setNumtabs(int numtabs) {
        this.numtabs = numtabs;
    } 
    
    public synchronized List<Expediente> getExpedientes(){
        if(usuario == null)
            return null;
        else if(isTecnicoSuperior() || isAuxiliarAdministrativo())
           return negocioExpediente.getExpedientes();
        else
           return usuario.getExpedientes();
    }
    
    public synchronized List<Intervencion> getIntervenciones(){
        return negocioExpediente.getIntervenciones();
    }
    
    public boolean isTecnicoSuperior(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Tecnico Superior".trim().toUpperCase())){
            is=true;
        }
        
        return is;
    }
    public boolean isProfesional(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Profesional".trim().toUpperCase())){
            is=true;
        }
        
        return is;
    }
    public boolean isAuxiliarAdministrativo(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Auxiliar administrativo".trim().toUpperCase())){
            is=true;
        }
        return is;
    }
    
    public void refrescarUsuario(){
        usuario = cuenta.refrescarUsuario(usuario);
        refrescarExpediente();
    }
    
    public void refrescarExpediente(){
        expediente = negocioExpediente.refrescarExpediente(expediente);
    }
    
    public String redireccionar(){
        return usuario == null ? "login.xhtml" : "bienvenida.xhtml";
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
    public String formatFecha(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        if(fecha == null)
            return "";
        return df.format(fecha);     
    }
    
}

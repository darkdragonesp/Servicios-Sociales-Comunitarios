/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Intervencion;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author FranciscoJosé
 */
@ManagedBean(name = "expedienteController")
@SessionScoped

public class ExpedienteController {
    private Expediente expediente = new Expediente();
    private Ciudadano ciudadano = new Ciudadano();
    private Ciudadano pariente = new Ciudadano();
    private String parentescoSeleccionado1;
    private String parentescoSeleccionado2;
    private Expediente selectedExpediente;
    private Intervencion intervencion, editIntervencion;
    
    public ExpedienteController(){ 
        pariente = new Ciudadano();
        ciudadano = new Ciudadano();
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

    public Intervencion getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(Intervencion intervencion) {
        this.intervencion = intervencion;
    }

    public Intervencion getEditIntervencion() {
        return editIntervencion;
    }

    public void setEditIntervencion(Intervencion editIntervencion) {
        this.editIntervencion = editIntervencion;
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
    }
    
    public String editarIntervencion(Intervencion intervencion){
        this.intervencion = intervencion;
        editIntervencion = new Intervencion(this.intervencion);

        return "editar_intervencion.xhtml";
    }
    
    public String verExpediente(Expediente expediente){
        this.expediente = expediente;
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
        for (Ciudadano ciudadano : this.expediente.getCiudadanos()) {
            if(ciudadano.getDni().equals(dni)) {
                return ciudadano;
            }
        }
        return null;
    }
    
    public String addIntervencion(Intervencion intervencion){
        intervencion.setId(asignarIdIntervencion());
        long id = intervencion.getId();
        if(expediente.getIntervenciones().add(intervencion)){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Intervención "+id+" añadida"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        return "expediente.xhtml";
    }
    
    public long asignarIdIntervencion(){
        return expediente.getIntervenciones().size()+1;
    }
    
    public void eliminarCiudadano(String dni) {
        this.expediente.getCiudadanos().remove(obtenerCiudadano(dni));
    }
    
    public void eliminarIntervencion(Expediente expediente, Intervencion intervencion){
        long id = intervencion.getId();
        if(expediente.getIntervenciones().remove(intervencion)){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Intervención "+id+" eliminada"));
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
public class ExpedienteController implements Serializable{
    private Expediente expediente;
    private Expediente selectedExpediente;
    private Ciudadano ciudadano;
    
    
    public ExpedienteController() { 

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

    public Expediente getSelectedExpediente() {
        return selectedExpediente;
    }

    public void setSelectedExpediente(Expediente selectedExpediente) {
        this.selectedExpediente = selectedExpediente;
    }
    
    public String verExpediente(Expediente expediente){
        this.expediente = expediente;
        return "expediente.xhtml";
    }
    
    public String verCiudadano(String dni) {
        ciudadano = obtenerCiudadano(dni);
        return "ciudadano.xhtml";
    }
    
    public Ciudadano obtenerCiudadano(String dni) {
        List<Ciudadano> ciudadanos = expediente.getCiudadanos();
        for (Ciudadano ciudadano : ciudadanos) {
            if(ciudadano.getDni().equals(dni)) {
                return ciudadano;
            }
        }
        return null;
    }
    
    public String addIntervencion(Intervencion intervencion){
        intervencion.setId(asignarIdIntervencion());
        expediente.getIntervenciones().add(intervencion);
        return "expediente.xhtml";
    }
    
    public long asignarIdIntervencion(){
        return expediente.getIntervenciones().size()+1;
    }
    
    public void eliminarCiudadano(String dni) {
        this.expediente.getCiudadanos().remove(obtenerCiudadano(dni));
    }
    
    public String formatFecha(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        return df.format(fecha);     
    }
    
    public void onRowSelect(SelectEvent event){
       selectedExpediente = (Expediente) event.getObject();
    }
}

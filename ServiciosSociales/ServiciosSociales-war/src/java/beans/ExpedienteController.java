/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Persona;

/**
 *
 * @author FranciscoJosé
 */

@Named
@ManagedBean
@SessionScoped
public class ExpedienteController {
    private Expediente expediente = new Expediente();
    private Ciudadano ciudadano = new Ciudadano();
    
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
    
    public String verExpediente(Expediente expediente){
        List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
        ciudadanos.add(new Ciudadano("25354845J", "Francisco Jose", "Torralvo", "Ariza"));
        ciudadanos.add(new Ciudadano("1", "Juan Jose", "Trujillo", "Bueno"));
        ciudadanos.add(new Ciudadano("2", "Robin", "Sorries", null));
        ciudadanos.add(new Ciudadano("3", "Laura", "Urbano", "Salinas"));
        ciudadanos.add(new Ciudadano("4", "Francisco", "Molina", "Sanchez"));
        expediente.setCiudadanos(ciudadanos);
        this.expediente = expediente;
        return "expediente.xhtml";
    }
    
    public String verCiudadano(String dni) {
        this.ciudadano = obtenerCiudadano(dni);
        return "ciudadano.xhtml";
    }
    
    public Ciudadano obtenerCiudadano(String dni) {
        List<Ciudadano> ciudadanos = this.expediente.getCiudadanos();
        for (Ciudadano ciudadano : ciudadanos) {
            if(ciudadano.getDni().equals(dni)) {
                return ciudadano;
            }
        }
        return null;
    }
    
    public void eliminarCiudadano(String dni) {
        this.expediente.getCiudadanos().remove(obtenerCiudadano(dni));
    }
    
    public String actualizarCiudadano() {
        return "ciudadano.xhtml";
    }
}

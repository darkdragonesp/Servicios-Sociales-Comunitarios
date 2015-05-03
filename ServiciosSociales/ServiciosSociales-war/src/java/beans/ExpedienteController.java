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
    
//    public ExpedienteController() {
//    }
    
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
        this.expediente = expediente;
        Ciudadano[] ciudadanos = new Ciudadano[5];
        ciudadanos[0] = new Ciudadano();
        ciudadanos[0].setDni("25354845J");
        ciudadanos[0].setPersona(new Persona());
        ciudadanos[0].getPersona().setNombre("Francisco Jose");
        ciudadanos[0].getPersona().setApellido1("Torralvo");
        ciudadanos[0].getPersona().setApellido2("Ariza");
        ciudadanos[1] = new Ciudadano();
        ciudadanos[1].setDni("1");
        ciudadanos[1].setPersona(new Persona());
        ciudadanos[1].getPersona().setNombre("Juan Jose");
        ciudadanos[1].getPersona().setApellido1("Trujillo");
        ciudadanos[1].getPersona().setApellido2("Bueno");
        ciudadanos[2] = new Ciudadano();
        ciudadanos[2].setDni("2");
        ciudadanos[2].setPersona(new Persona());
        ciudadanos[2].getPersona().setNombre("Robin");
        ciudadanos[2].getPersona().setApellido1("Sorries");
        ciudadanos[2].getPersona().setApellido2("");
        ciudadanos[3] = new Ciudadano();
        ciudadanos[3].setDni("3");
        ciudadanos[3].setPersona(new Persona());
        ciudadanos[3].getPersona().setNombre("Laura");
        ciudadanos[3].getPersona().setApellido1("Urbano");
        ciudadanos[3].getPersona().setApellido2("Salinas");
        ciudadanos[4] = new Ciudadano();
        ciudadanos[4].setDni("4");
        ciudadanos[4].setPersona(new Persona());
        ciudadanos[4].getPersona().setNombre("Francisco");
        ciudadanos[4].getPersona().setApellido1("Molina");
        ciudadanos[4].getPersona().setApellido2("Sanchez");
        this.expediente.setCiudadanos(new ArrayList<Ciudadano>(Arrays.asList(ciudadanos)));
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
}

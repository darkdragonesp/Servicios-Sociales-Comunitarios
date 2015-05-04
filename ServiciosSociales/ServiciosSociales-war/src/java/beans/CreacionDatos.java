/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Intervencion;
import modelo.Persona;

/**
 *
 * @author JuanJo
 */
@ManagedBean
@SessionScoped
public class CreacionDatos implements Serializable{
    private List<Expediente> expedientes;
    //private Ciudadano ciudadano = new Ciudadano();
    /**
     * Creates a new instance of CreacionDatos
     */
    public CreacionDatos() {
        expedientes = new ArrayList<Expediente>();
        Date today = new Date();
        expedientes.add(new Expediente(12345678, today));
        expedientes.add(new Expediente(22245563, today));
        expedientes.add(new Expediente(39832492, today));
        expedientes.add(new Expediente(1234567855, today));
        expedientes.add(new Expediente(22245563, today));
        expedientes.add(new Expediente(39832492, today));
        expedientes.add(new Expediente(1234567855, today));
        
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
        
        for(Expediente e: expedientes){
            e.setIntervenciones(new ArrayList<Intervencion>());
            e.setCiudadanos(new ArrayList<Ciudadano>(Arrays.asList(ciudadanos)));
        }
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }
    
    
    
}

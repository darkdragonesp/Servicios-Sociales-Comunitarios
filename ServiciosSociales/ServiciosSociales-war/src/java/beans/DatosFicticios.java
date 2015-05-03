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
import javax.faces.bean.ApplicationScoped;
import modelo.Actividad;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Intervencion;
import modelo.Parentesco;
import modelo.Persona;
import modelo.UTS;
import modelo.Usuario;

/**
 *
 * @author FranciscoJosé
 */
@ManagedBean
@ApplicationScoped
public class DatosFicticios {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Expediente> expedientes = new ArrayList<Expediente>();
    private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
    private List<Intervencion> intervenciones;
    private List<Actividad> actividades;
    private List<UTS> uts;
    private List<Parentesco> parentescos;
    
    
    public DatosFicticios() {
        expedientes.add(new Expediente(12345678));
        expedientes.add(new Expediente(22245563));
        expedientes.add(new Expediente(39832492));
        expedientes.add(new Expediente(12345678));
        expedientes.add(new Expediente(22245563));
        expedientes.add(new Expediente(39832492));
        expedientes.add(new Expediente(1234567855));
        ciudadanos.add(new Ciudadano("25354845J", "Francisco Jose", "Torralvo", "Ariza"));
        ciudadanos.add(new Ciudadano("1", "Juan Jose", "Trujillo", "Bueno"));
        ciudadanos.add(new Ciudadano("2", "Robin", "Sorries", null));
        ciudadanos.add(new Ciudadano("3", "Laura", "Urbano", "Salinas"));
        ciudadanos.add(new Ciudadano("4", "Francisco", "Molina", "Sanchez"));
        usuarios.add(new Usuario("33333333P"));
        usuarios.add(new Usuario("22222222J"));
        usuarios.add(new Usuario("11111111H"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public List<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(List<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public List<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervencion> intervenciones) {
        this.intervenciones = intervenciones;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<UTS> getUts() {
        return uts;
    }

    public void setUts(List<UTS> uts) {
        this.uts = uts;
    }

    public List<Parentesco> getParentescos() {
        return parentescos;
    }

    public void setParentescos(List<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }
}

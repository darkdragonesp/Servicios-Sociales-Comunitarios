/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Actividad;
import entidades.Ciudadano;
import entidades.Expediente;
import entidades.Intervencion;
import entidades.Parentesco;
import entidades.ParentescoID;
import entidades.UTS;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import negocio.CiudadanoLocal;
import negocio.ExpedienteLocal;

/**
 *
 * @author FranciscoJosé
 */
@ManagedBean(name = "datosFicticios")
@ApplicationScoped
public class DatosFicticios {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Expediente> expedientes = new ArrayList<Expediente>();
    private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
    private List<Intervencion> intervenciones;
    private List<Actividad> actividades;
    private List<UTS> uts=new ArrayList<UTS>();
    private List<Parentesco> parentescos = new ArrayList<Parentesco>();
    
    @EJB
    private CiudadanoLocal ciudadanoEJB;
    @EJB
    private ExpedienteLocal expedienteEJB;
    
    public DatosFicticios() {
        Date today = new Date();
        Expediente e1 = new Expediente(12345678, today);
        List<Intervencion> e1intervenciones = new ArrayList<Intervencion>();
        e1.setIntervenciones(e1intervenciones);
        Ciudadano c1 = new Ciudadano("11111111A", "Joan Manuel", "Serrat", "Teresa");
        Ciudadano c2 = new Ciudadano("22222222A", "Joaquin Ramon", "Martinez", "Sabina");
        ciudadanos.add(c1);
        ciudadanos.add(c2);
        List<Ciudadano> lc1 = new ArrayList<Ciudadano>();
        lc1.add(c1);
        lc1.add(c2);
        c1.setExpediente(e1);
        c2.setExpediente(e1);
        e1.setCiudadanos(lc1);
        expedientes.add(e1);
        
        Expediente e2 = new Expediente(22245563, today);
        List<Intervencion> e2intervenciones = new ArrayList<Intervencion>();
        e2.setIntervenciones(e2intervenciones);
        Ciudadano c3 = new Ciudadano("33333333A", "Jose Miguel", "Conejo", "Torres");
        Ciudadano c4 = new Ciudadano("44444444A", "Ruben", "Pozo", "Prats");
        ciudadanos.add(c3);
        ciudadanos.add(c4);
        List<Ciudadano> lc2 = new ArrayList<Ciudadano>();
        lc2.add(c3);
        lc2.add(c4);
        c3.setExpediente(e2);
        c4.setExpediente(e2);
        e2.setCiudadanos(lc2);
        expedientes.add(e2);
//        expedientes.add(new Expediente(22245563));
//        expedientes.add(new Expediente(39832492));
//        expedientes.add(new Expediente(12345678));
//        expedientes.add(new Expediente(22245563));
//        expedientes.add(new Expediente(39832492));
//        expedientes.add(new Expediente(1234567855));
//        ciudadanos.add(new Ciudadano("1", "Francisco Jose", "Torralvo", "Ariza"));
//        ciudadanos.add(new Ciudadano("2", "Juan Jose", "Trujillo", "Bueno"));
//        ciudadanos.add(new Ciudadano("3", "Robin", "Sorries", null));
//        ciudadanos.add(new Ciudadano("4", "Laura", "Urbano", "Salinas"));
//        ciudadanos.add(new Ciudadano("5", "Francisco", "Molina", "Sanchez"));

        
        actividades = new ArrayList<Actividad>();
     
        usuarios.add(new Usuario("33333333P", "1234","Tecnico Superior"));
        usuarios.add(new Usuario("22222222J", "1234","Auxiliar administrativo"));
        usuarios.add(new Usuario("11111111H", "1234","Profesional"));
        
        usuarios.get(2).setActividades(actividades);

        Actividad a1 = new Actividad("Trabajo supervisión", today, today, "Málaga");
        Actividad a2 = new Actividad("Descanso", today, today, "Málaga");
        actividades.add(a1);
        actividades.add(a2);
        
        usuarios.get(2).setActividades(actividades);
        usuarios.get(0).setActividades(new ArrayList<Actividad>());
        usuarios.get(1).setActividades(new ArrayList<Actividad>());
       
        uts.add(new UTS((long)1,"Sur","El Palo","Malaga"));
        uts.add(new UTS((long)2,"Norte","Teatinos","Malaga"));
        uts.add(new UTS((long)3,"Centro","Antequera","Malaga"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Expediente> getExpedientes() {
        this.expedientes = expedienteEJB.getExpedientes();
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public List<Ciudadano> getCiudadanos() {
        this.ciudadanos = ciudadanoEJB.getCiudadanos();
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
}

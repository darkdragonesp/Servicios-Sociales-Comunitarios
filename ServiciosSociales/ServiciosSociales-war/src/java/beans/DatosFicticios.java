/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import modelo.Actividad;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Intervencion;
import modelo.Parentesco;
import modelo.ParentescoID;
import modelo.UTS;
import modelo.Usuario;

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
     
        usuarios.add(new Usuario("33333333P", "1234","Técnico Superior"));
        usuarios.add(new Usuario("22222222J", "1234","Auxiliar Administrativo"));
        usuarios.add(new Usuario("11111111H", "1234","Profesional"));
        
        usuarios.get(2).setActividades(actividades);
       
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
    
    public Ciudadano obtenerCiudadano(String dni) {
        for (Ciudadano ciudadano : this.ciudadanos) {
            if(ciudadano.getDni().equals(dni)) return ciudadano;
        }
        return null;
    }
    
    public Expediente obtenerExpediente(String id) {
        for (Expediente expediente : this.expedientes) {
            if (expediente.getId().equals(id)) return expediente;
        }
        return null;
    }
    
    public Parentesco obtenerParentesco(Ciudadano ciudadano, Ciudadano pariente) {
        List<Parentesco> parentescos = ciudadano.getParentescos();
        for (Parentesco parentesco : parentescos) {
            if (parentesco.getCiudadano2().getDni().equals(pariente.getDni())) return parentesco;
        }
        return null;
    }
    
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano) {
        expediente.getCiudadanos().remove(ciudadano);
    }
    
    public void eliminarParentesco(Ciudadano ciudadano, Ciudadano pariente) {
        pariente.getParentescos().remove(obtenerParentesco(pariente, ciudadano));
        ciudadano.getParentescos().remove(obtenerParentesco(ciudadano, pariente));
    }
    
    public void anadirParentesco(Ciudadano ciudadano, Ciudadano pariente, String parentescoSeleccionado1, String parentescoSeleccionado2) {
        System.out.println("Entrada ciudadano: "+ciudadano);
        System.out.println("Entrada pariente: "+pariente);
        Parentesco parentesco = new Parentesco();
        parentesco.setCiudadano1(ciudadano);
        parentesco.setCiudadano2(pariente);
        parentesco.setParentesco(parentescoSeleccionado1);
        parentesco.setParentescoPK(new ParentescoID(ciudadano.getDni(), pariente.getDni()));
        List<Parentesco> parentescos = ciudadano.getParentescos();
        if (parentescos==null) parentescos=new ArrayList<>();
        parentescos.add(parentesco);
        ciudadano.setParentescos(parentescos);
        Parentesco parentesco2 = new Parentesco();
        parentesco2.setCiudadano1(pariente);
        parentesco2.setCiudadano2(ciudadano);
        parentesco2.setParentesco(parentescoSeleccionado2);
        parentesco2.setParentescoPK(new ParentescoID(pariente.getDni(), ciudadano.getDni()));
        List<Parentesco> parentescos2 = pariente.getParentescos();
        if (parentescos2==null) parentescos2=new ArrayList<>();
        parentescos2.add(parentesco2);
        pariente.setParentescos(parentescos2);
        this.parentescos.add(parentesco);
        this.parentescos.add(parentesco2);
    }
    
    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano) {
        System.out.println("EXPEDIENTE ENTRADA: "+expediente);
        System.out.println("CIUDADANOS ENTRADA: "+expediente.getCiudadanos());
        System.out.println("CIUDADANO ENTRADA: "+ciudadano);
        List<Ciudadano> ciudadanos = expediente.getCiudadanos();
        if (ciudadanos==null) ciudadanos = new ArrayList<Ciudadano>();
        ciudadanos.add(ciudadano);
        if (ciudadano.getExpediente().getCiudadanos()!=null) {
            ciudadano.getExpediente().getCiudadanos().remove(ciudadano);
        }
        ciudadano.setExpediente(expediente);
        expediente.setCiudadanos(ciudadanos);
    }
    
    public String crearCiudadano(Ciudadano ciudadano, Expediente expediente) {
        this.ciudadanos.add(ciudadano);
        if (expediente!=null) {
            anadirCiudadano(expediente, ciudadano);
        }
        return "expedientes.xhtml";
    }
    
    public String crearExpediente(Expediente expediente) {
        this.expedientes.add(expediente);
        return "expedientes.xhtml";
    }
}

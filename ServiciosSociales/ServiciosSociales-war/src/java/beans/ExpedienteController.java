/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import modelo.Ciudadano;
import modelo.Expediente;
import modelo.Parentesco;
import modelo.ParentescoID;
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
    private String ciudadanoSeleccionado;
    private String parentescoSeleccionado1;
    private String parentescoSeleccionado2;
    private Date fechaNacimiento;
    private Date fechaApertura;
    private Date fechaCierre;
    
    public ExpedienteController() { }
    
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

    public String getCiudadanoSeleccionado() {
        return ciudadanoSeleccionado;
    }

    public void setCiudadanoSeleccionado(String ciudadanoSeleccionado) {
        this.ciudadanoSeleccionado = ciudadanoSeleccionado;
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
    
    public String verExpediente(Expediente expediente){
        List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
        ciudadanos.add(new Ciudadano("25354845J", "Francisco Jose", "Torralvo", "Ariza"));
        ciudadanos.add(new Ciudadano("1", "Juan Jose", "Trujillo", "Bueno"));
        ciudadanos.add(new Ciudadano("2", "Robin", "Sorries", null));
        ciudadanos.add(new Ciudadano("3", "Laura", "Urbano", "Salinas"));
        ciudadanos.add(new Ciudadano("4", "Francisco", "Molina", "Sanchez"));
        expediente.setCiudadanos(ciudadanos);
        this.expediente = expediente;
        for (Ciudadano ciudadano : ciudadanos) {
            ciudadano.setExpediente(expediente);
        }
        return "expediente.xhtml";
    }
    
    public String verCiudadano(String dni) {
        this.ciudadano = obtenerCiudadano(dni);
        return "ciudadano.xhtml";
    }
    
    public String verEditarCiudadano(String dni) {
        this.ciudadano = obtenerCiudadano(dni);
        return "editar-ciudadano.xhtml";
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
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
    
    public Parentesco obtenerParentesco(Ciudadano ciudadano, String dni) {
        List<Parentesco> parentescos = ciudadano.getParentescos();
        for (Parentesco parentesco : parentescos) {
            if (parentesco.getCiudadano2().getDni().equals(dni)) return parentesco;
        }
        return null;
    }
    
    public void eliminarCiudadano(String dni) {
        this.expediente.getCiudadanos().remove(obtenerCiudadano(dni));
    }
    
    public void eliminarParentesco(String dni) {
        Ciudadano pariente = obtenerCiudadano(dni);
        pariente.getParentescos().remove(obtenerParentesco(pariente, this.ciudadano.getDni()));
        this.ciudadano.getParentescos().remove(obtenerParentesco(this.ciudadano, dni));
    }
    
    public String actualizarCiudadano() {
        ciudadano.getPersona().setFechaNacimiento(new java.sql.Date(fechaNacimiento.getTime()));
        return "ciudadano.xhtml";
    }
    
    public String actualizarExpediente() {
        expediente.setFechaApertura(new java.sql.Date(fechaApertura.getTime()));
        if (this.fechaCierre!=null)expediente.setFechaCierre(new java.sql.Date(fechaCierre.getTime()));
        return "expediente.xhtml";
    }
    
    public void anadirParentesco() {
        Ciudadano pariente = obtenerCiudadano(ciudadanoSeleccionado);
        Parentesco parentesco = new Parentesco();
        parentesco.setCiudadano1(this.ciudadano);
        parentesco.setCiudadano2(pariente);
        parentesco.setParentesco(parentescoSeleccionado1);
        parentesco.setParentescoPK(new ParentescoID(this.ciudadano.getDni(), ciudadanoSeleccionado));
        List<Parentesco> parentescos = this.ciudadano.getParentescos();
        if (parentescos==null) parentescos=new ArrayList<>();
        parentescos.add(parentesco);
        this.ciudadano.setParentescos(parentescos);
        Parentesco parentesco2 = new Parentesco();
        parentesco2.setCiudadano1(pariente);
        parentesco2.setCiudadano2(this.ciudadano);
        parentesco2.setParentesco(parentescoSeleccionado2);
        parentesco2.setParentescoPK(new ParentescoID(ciudadanoSeleccionado, this.ciudadano.getDni()));
        List<Parentesco> parentescos2 = pariente.getParentescos();
        if (parentescos2==null) parentescos2=new ArrayList<>();
        parentescos2.add(parentesco2);
        pariente.setParentescos(parentescos2);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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
    private Ciudadano pariente = new Ciudadano();
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
    
    public String verExpediente(Expediente expediente){
        this.expediente = expediente;
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
        for (Ciudadano ciudadano : this.expediente.getCiudadanos()) {
            if(ciudadano.getDni().equals(dni)) {
                return ciudadano;
            }
        }
        return null;
    }

    public String formatFecha(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        return df.format(fecha);     
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import modelo.Expediente;
import modelo.Intervencion;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "crearIntervencion")
@RequestScoped
public class CrearIntervencion implements Serializable{
    private Intervencion intervencion;
    
    @ManagedProperty(value = "#{expedienteController}")
    private ExpedienteController expctrl;
    
    private Date fechaInicio; 
    private Date fechaFin;
    private String valoracion;
    private String tipo;
    private String recursoAplicado;
    private String recursoIdeal;
    private String ayuda;
    private String notas; 
    
    /**
     * Creates a new instance of crearIntervencion
     */
    public CrearIntervencion() {
        
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setExpctrl(ExpedienteController expctrl) {
        this.expctrl = expctrl;
    }
    
    
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecursoAplicado() {
        return recursoAplicado;
    }

    public void setRecursoAplicado(String recursoAplicado) {
        this.recursoAplicado = recursoAplicado;
    }

    public String getRecursoIdeal() {
        return recursoIdeal;
    }

    public void setRecursoIdeal(String recursoIdeal) {
        this.recursoIdeal = recursoIdeal;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    public String editarIntervencion(){
        Expediente expediente = expctrl.getExpediente();
        expediente.getIntervenciones().set(expediente.getIntervenciones().indexOf(expctrl.getIntervencion()), expctrl.getEditIntervencion());
        return "expediente.xhtml";
    }
    
    public String cancelarEditarIntervencion(){
        return "expediente.xhtml";
    }
    
    public String crearIntervencion(){
        intervencion = new Intervencion();
        intervencion.setFechaInicio(fechaInicio);
        intervencion.setFechaFin(fechaFin);
        intervencion.setNotas(notas);
        intervencion.setRecursoAplicado(recursoAplicado);
        intervencion.setRecursoIdeal(recursoIdeal);
        intervencion.setTipo(tipo);
        intervencion.setValoracion(valoracion);
        return expctrl.addIntervencion(intervencion);
    }
    
}

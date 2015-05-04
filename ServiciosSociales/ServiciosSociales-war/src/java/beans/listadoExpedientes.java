/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Expediente;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author JuanJo
 */
@ManagedBean
@SessionScoped
public class listadoExpedientes implements Serializable{
    private List<Expediente> expedientes;
    private Expediente selectedExpediente;
    
    /**
     * Creates a new instance of listadoExpedientes
     */

    public listadoExpedientes() throws ParseException {
//        expedientes = new ArrayList<Expediente>();
//        Date today = new Date();
//        expedientes.add(new Expediente(12345678, today));
//        expedientes.add(new Expediente(22245563, today));
//        expedientes.add(new Expediente(39832492, today));
//        expedientes.add(new Expediente(1234567855, today));
    }
    
    public Expediente getSelectedExpediente() {
        return selectedExpediente;
    }
    
    public void onRowSelect(SelectEvent event){
       selectedExpediente = (Expediente) event.getObject();
    }
 
    public void setSelectedExpediente(Expediente selectedExpediente) {
        this.selectedExpediente = selectedExpediente;
    }
 
    public List<Expediente> getExpedientes(){
        return expedientes;
    }
    
    public void setExpedientes(List<Expediente> expedientes){
        this.expedientes = expedientes;
    }
    
    public String listarExpedientes(){
        // Devuelve expedientes dependiendo del usuario
        return "expedientes.xhtml";
    }
    
}

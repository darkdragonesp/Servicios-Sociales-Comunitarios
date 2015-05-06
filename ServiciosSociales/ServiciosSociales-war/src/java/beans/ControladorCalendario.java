/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Actividad;
import modelo.Usuario;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "controladorCalendario")
@SessionScoped
public class ControladorCalendario implements Serializable{
    private ScheduleModel modelo;
    private ScheduleEvent actividad = new DefaultScheduleEvent();
    private Actividad ac;
    private Usuario usuario;
    private List<Actividad> actividades;
    private String lugar;
    
    @ManagedProperty(value = "#{login}")
    private Login login;
    /**
     * Creates a new instance of VistaCalendario
     */
    public ControladorCalendario() {
        /*usuario = login.getUser();
        actividades = usuario.getActividades();
        modelo = new DefaultScheduleModel();
        
        for(Actividad a: actividades){
            modelo.addEvent(new DefaultScheduleEvent(a.getDescripcion(), a.getFecha(), a.getFecha(), a));
        }*/
        
        /*modelo.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
        modelo.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
        modelo.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
        modelo.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));*/
        //actividad = new DefaultScheduleEvent();
    }
    
    @PostConstruct
    public void init(){
        ac = new Actividad();
        usuario = login.getUser();
        actividades = usuario.getActividades();
        modelo = new DefaultScheduleModel();
        
        if(actividades.size() > 0){
            for(Actividad a: actividades){
                modelo.addEvent(new DefaultScheduleEvent(a.getDescripcion(), a.getFecha(), a.getFecha(), a));
            }
        }    
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    public ScheduleModel getModelo() {
        return modelo;
    }

    public Actividad getAc() {
        return ac;
    }

    public void setAc(Actividad ac) {
        this.ac = ac;
    }

    public void setModelo(ScheduleModel modelo) {
        this.modelo = modelo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

//    public Date getHora() {
//        return hora;
//    }
//
//    public void setHora(Date hora) {
//        this.hora = hora;
//    }
    

    public ScheduleEvent getActividad() {
        return actividad;
    }

    public void setActividad(ScheduleEvent actividad) {
        this.actividad = actividad;
    }   
    
    public void onSeleccionarFecha(SelectEvent event){
        actividad = new DefaultScheduleEvent("", (Date) event.getObject(), (Date) event.getObject());
    }
    
    public void onSeleccionarActividad(SelectEvent event) {
        actividad = (ScheduleEvent) event.getObject();
        ac = (Actividad)actividad.getData();
        lugar = ac.getLugar();
        System.out.println(ac);
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad desplazada", "Días:" + event.getDayDelta()); 
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad reprogramada", "Días:" + event.getDayDelta()+ " , Minutos:" + event.getMinuteDelta());        
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addActividad(){
        if(actividad.getId() == null){
            Actividad a = new Actividad(actividad.getTitle(), actividad.getStartDate());
            a.setLugar(new String(lugar));
            DefaultScheduleEvent aux = (DefaultScheduleEvent)actividad;
            System.out.println("event "+aux);
            
            modelo.addEvent(aux);
            // Ya esta en el calendario, ahora la procesamos en las actividades de usuario
            
            a.setId(aux.getId());
            aux.setData(a);
            actividades.add(a);
        }else{
            modelo.updateEvent(actividad);
            Actividad aux = (Actividad)actividad.getData();
            Actividad nueva = new Actividad(actividad.getTitle(), actividad.getStartDate());
            System.out.println(ac);
            System.out.println(aux);
            nueva.setLugar(new String(lugar));
            actividades.set(actividades.indexOf(aux), nueva);
        }
        actividad = new DefaultScheduleEvent();
    }
    
    public void deleteActividad(){
        modelo.deleteEvent(actividad);
        actividades.remove((Actividad)actividad.getData());
    }
    
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
    
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
//    private Date previousDay8Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 8);
//         
//        return t.getTime();
//    }
//     
//    private Date previousDay11Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 11);
//         
//        return t.getTime();
//    }
//     
//    private Date today1Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 1);
//         
//        return t.getTime();
//    }
//     
//    private Date theDayAfter3Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 3);
//         
//        return t.getTime();
//    }
// 
//    private Date today6Pm() {
//        Calendar t = (Calendar) today().clone(); 
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 6);
//         
//        return t.getTime();
//    }
//     
//    private Date nextDay9Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 9);
//         
//        return t.getTime();
//    }
//     
//    private Date nextDay11Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 11);
//         
//        return t.getTime();
//    }
//     
//    private Date fourDaysLater3pm() {
//        Calendar t = (Calendar) today().clone(); 
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
//        t.set(Calendar.HOUR, 3);
//         
//        return t.getTime();
//    }
    
}

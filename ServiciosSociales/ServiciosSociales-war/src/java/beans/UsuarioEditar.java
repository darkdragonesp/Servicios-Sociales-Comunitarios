/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Usuario;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import negocio.EditarUsuarioLocal;

/**
 *
 * @author Portátil
 */
/*@Named(value = "usuarioEditar")
@SessionScoped*/
@ManagedBean
@SessionScoped
public class UsuarioEditar implements Serializable {
    /*private String text;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private Integer telefono;
    private Character sexo;
    private String estadoCivil;
    private Date fechaNacimiento;
    private String localidad;
    private String nacionalidad;
    private String email;
    private String contrasenya;*/
    private String contrasenya2;
    
    private Usuario selectedUsuario;
    @EJB
    private EditarUsuarioLocal bd;

    @ManagedProperty(value = "#{controlAutorizacion}")
    private ControlAutorizacion ctrl;

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public UsuarioEditar(){
        
        /*this.apellido1 = selectedUsuario.getPersona().getApellido1();
        this.apellido2 = selectedUsuario.getPersona().getApellido2();
        this.contrasenya = selectedUsuario.getContrasena();
        this.contrasenya2 = selectedUsuario.getContrasena();
        this.direccion = selectedUsuario.getPersona().getDireccion();
        this.dni=selectedUsuario.getDni();
        this.email=selectedUsuario.getPersona().getEmail();
        this.estadoCivil=selectedUsuario.getPersona().getEstadoCivil();
        this.fechaNacimiento=selectedUsuario.getPersona().getFechaNacimiento();
        this.localidad=selectedUsuario.getPersona().getLocalidad();
        this.nacionalidad=selectedUsuario.getPersona().getNacionalidad();
        this.nombre=selectedUsuario.getPersona().getNombre();
        this.sexo=selectedUsuario.getPersona().getSexo();
        this.telefono=selectedUsuario.getPersona().getTelefono();*/
    }
    
    @PostConstruct
    public void init(){
        selectedUsuario = ctrl.getUsuarioSeleccionado();
    }

    /*public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    */
    public String getContrasenya2() {
        return contrasenya2;
    }

    public void setContrasenya2(String contrasenya2) {
        this.contrasenya2 = contrasenya2;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    /*
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    */
    public String enviar(){
        if(!selectedUsuario.getContrasena().equals(getContrasenya2())){
            return "usuarioEditar.xhtml?faces-redirect=true";
        }else{
            
            /*selectedUsuario.getPersona().setApellido1(apellido1);
            selectedUsuario.getPersona().setApellido2(apellido2);
            selectedUsuario.getPersona().setDireccion(direccion);
            selectedUsuario.getPersona().setDni(dni);
            selectedUsuario.getPersona().setEmail(email);
            selectedUsuario.getPersona().setEstadoCivil(estadoCivil);
            selectedUsuario.getPersona().setFechaNacimiento(fechaNacimiento);
            selectedUsuario.getPersona().setLocalidad(localidad);
            selectedUsuario.getPersona().setNombre(nombre);
            selectedUsuario.getPersona().setNacionalidad(nacionalidad);
            selectedUsuario.getPersona().setSexo(sexo);
            selectedUsuario.getPersona().setTelefono(telefono);*/
            selectedUsuario.setContrasena(ctrl.sha256(contrasenya2));
            bd.modificar(selectedUsuario); 
            bd.modificarP(selectedUsuario.getPersona());
            return "bienvenida.xhtml?faces-redirect=true";
        }
        
    }
  
    
}

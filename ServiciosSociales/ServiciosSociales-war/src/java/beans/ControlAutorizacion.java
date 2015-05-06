/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion {
    private Usuario usuario;
    
    public ControlAutorizacion() {
    
    }

    public Usuario getUsuario() {
        System.out.println("Usuario "+usuario);
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean isTecnicoSuperior(){
        boolean is = false;
        if(usuario.getTipoProfesional().equals("Tecnico Superior")){
            is=true;
        }
        
        return is;
    }
    public boolean isProfesional(){
        boolean is = false;
        if(usuario.getTipoProfesional().equals("Profesional")){
            is=true;
        }
        
        return is;
    }
    public boolean isAuxiliarAdministrativo(){
        boolean is = false;
        if(usuario.getTipoProfesional().equals("Auxiliar administrativo")){
            is=true;
        }
        return is;
    }
    
    public String redireccionar(){
        return usuario == null ? "login.xhtml" : "bienvenida.xhtml";
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
}

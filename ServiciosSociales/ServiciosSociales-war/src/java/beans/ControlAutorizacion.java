/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JuanJo
 */
@ManagedBean(name = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable{
    private Usuario usuario;
    
    public ControlAutorizacion() {
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean isTecnicoSuperior(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Tecnico Superior".trim().toUpperCase())){
            is=true;
        }
        
        return is;
    }
    public boolean isProfesional(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Profesional".trim().toUpperCase())){
            is=true;
        }
        
        return is;
    }
    public boolean isAuxiliarAdministrativo(){
        boolean is = false;
        if(usuario.getTipoProfesional().trim().toUpperCase().equals("Auxiliar administrativo".trim().toUpperCase())){
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

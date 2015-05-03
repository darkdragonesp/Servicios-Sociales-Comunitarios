/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;

/**
 *
 * @author Portátil
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    private String usuario;
    private String password;  
    ArrayList<Usuario> usuarios;
    
    public Login(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("11111111H","1234"));
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String validar(){
        for(Usuario s : usuarios){
            if(s.getDni().equals(usuario)){
                if(s.getDni().equals(password)){
                    return "bienvenida.xhtml";
                }else{
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña no válida", "Contraseña no válida"));
                    return null;
                }
            }
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no se encuentra", "El usuario no se encuentra"));
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

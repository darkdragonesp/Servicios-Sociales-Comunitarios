/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import entidades.Usuario;

/**
 *
 * @author Portátil
 */

@ManagedBean(name = "login")
@RequestScoped
public class Login implements Serializable {
    private String usuario;
    private String password;
    

    @ManagedProperty(value = "#{datosFicticios}")
    private DatosFicticios datos;
    
    @ManagedProperty(value = "#{controlAutorizacion}")
    private ControlAutorizacion ctrlau;
    
    public Login(){
        
    }
    
    public void setDatos(DatosFicticios datos) {
        this.datos = datos;
    }

    public void setCtrlau(ControlAutorizacion ctrlau) {
        this.ctrlau = ctrlau;
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
    
    public String autenticar(){
        List<Usuario> usuarios = datos.getUsuarios();
        Iterator<Usuario> it = usuarios.iterator();
        while(it.hasNext()){
            Usuario user = it.next();
            if(user.getDni().equals(getUsuario()) && user.getContrasena().equals(getPassword()))
                ctrlau.setUsuario(user);
        }
        
        if(ctrlau.getUsuario() == null){
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El usuario y/o contraseña es incorrecto"));
        }
  
        return ctrlau.redireccionar();
    }
}

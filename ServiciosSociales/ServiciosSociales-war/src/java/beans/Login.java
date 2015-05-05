/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import modelo.Usuario;

/**
 *
 * @author Portátil
 */
/*@Named(value = "login")
@SessionScoped*/
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    private String usuario;
    private String password;
    private ArrayList<Usuario> usuarios;
    private Usuario user = new Usuario();
    
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
        public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void validarusuario(FacesContext context,UIComponent component,Object input) throws ValidatorException {
        String var = (String)input;
        boolean esta=false;
        for(Usuario s: usuarios){
            if(s.getDni().equals(var)){
                esta=true;
                usuario=var;
                break;
            }
        }
        if(!esta){
           throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no existe", null));
        }
    
    }
    public void validarpassword(FacesContext context,UIComponent component,Object input) throws ValidatorException {
        String var = (String)input;
            boolean esta=false;

        for(Usuario s: usuarios){
            System.out.println(s.getContrasena());
            System.out.println(this.getUsuario());
            if(s.getDni().equals(this.getUsuario())){
                if(s.getContrasena().equals(var)){
                    esta=true;
                }
            }
        }
        if(!esta){
           throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta.", null));
        }
        
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    public String validar() throws ValidatorException{
      /*  for(Usuario s : usuarios){
            if(s.getDni().equals(usuario)){
                if(s.getDni().equals(password)){
                    return "bienvenida.xhtml";
                }else{
                    throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", null));
                }
            }
        }
        throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no Existe", null));
        }*/
        user = usuarios.get(usuarios.indexOf(user));
        return "bienvenida.xhtml";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import negocio.EditarUsuarioLocal;
/**
 *
 * @author Portátil
 */

@ManagedBean
@RequestScoped
public class UsuarioEditar implements Serializable {
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
     
    }
    
    @PostConstruct
    public void init(){
        selectedUsuario = ctrl.getUsuarioSeleccionado();
    }

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
    
    public String enviar(){
        if(!selectedUsuario.getContrasena().equals(getContrasenya2())){
            return "usuarioEditar.xhtml?faces-redirect=true";
        }else{
            selectedUsuario.setContrasena(ctrl.sha256(contrasenya2));
            bd.modificar(selectedUsuario); 
            bd.modificarP(selectedUsuario.getPersona());
            return "bienvenida.xhtml?faces-redirect=true";
        }
        
    }
}

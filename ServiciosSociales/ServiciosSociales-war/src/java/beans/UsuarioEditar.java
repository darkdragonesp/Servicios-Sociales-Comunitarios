/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;

/**
 *
 * @author Portátil
 */
@ManagedBean
@SessionScoped
public class UsuarioEditar implements Serializable {
    
   //  private String text;
  //  private String dni;
  //  private String nombre;
  //  private String apellido1;
  //  private String apellido2;
    private String direccion;
    private String telefono;
  //  private String sexo;
    private String estadoCivil;
    //  private Date fechaNacimiento;
    private String localidad;
  //  private String nacionalidad;
    private String email;
    private String contrasenya;
    private String contrasenya2;
    
    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    
    public UsuarioEditar(){
        usuarios = new ArrayList<Usuario>();
        selectedUsuario=new Usuario("11111111H");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public String getContrasenya2() {
        return contrasenya2;
    }

    public void setContrasenya2(String contrasenya2) {
        this.contrasenya2 = contrasenya2;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    public String enviar(){
        if(this.getContrasenya()!=this.getContrasenya2()){
            return "usuarioEditar.xhtml?faces-redirect=true";
        }else{
            usuarios.add(selectedUsuario);
            return "bienvenida.xhtml?faces-redirect=true";
        }
        
    }
  
    
}

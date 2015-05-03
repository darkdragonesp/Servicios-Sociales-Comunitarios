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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import modelo.Usuario;


/**
 *
 * @author DarkDragon
 */

@ManagedBean
@SessionScoped
public class usuarioAnyadirBean  implements Serializable{
    
    private String text;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String sexo;
    private String estadoCivil;
    private Date fechaNacimiento;
    private String localidad;
    private String nacionalidad;
    private String email;
    private String tipoProfesional;
    private String contrasenya;
    
    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    /**
     * Creates a new instance of usuarios
     */
    public usuarioAnyadirBean(){
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("33333333P"));
        usuarios.add(new Usuario("22222222J"));
        usuarios.add(new Usuario("11111111H"));
    }
    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }
    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario=selectedUsuario;
    }
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
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTipoProfesional() {
        return tipoProfesional;
    }
    
    public void setTipoProfesional(String tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }
    
    public String getContrasenya() {
        return contrasenya;
    }
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    private String calcularDNI(String s){
        String res="error";
        String letra="TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            int n=Integer.parseInt(s);
            if(n<0 || n>99999999){
                res="error";
            }else{
                n=n%23;
                res= letra.substring(n, n+1);
            }
            return res;
        } catch (NumberFormatException nfe){
            return "error";
        }
    }
    
    
    public void validarDni(FacesContext context,UIComponent component,Object input) throws ValidatorException {
        String var = (String)input;
        
        if(var.length() < 9){
            throw new ValidatorException(
                    new FacesMessage("Introduzca un DNI válido con una longitud igual a 9.", null));
        }
        if(!var.substring(8).equals(calcularDNI(var.substring(0,8)))){
            throw new ValidatorException(
                    new FacesMessage("Introduzca un DNI válido.La letra no coincide", null));
        }
        //si ya existe el DNI
        
        boolean esta=false;
        int cont=0;
        while(cont<usuarios.size()-1 && !esta){
            if(var.equalsIgnoreCase(usuarios.get(cont).getDni())){
                esta=true;
                throw new ValidatorException(
                        new FacesMessage("El DNI introducido ya existe en la base de datos.", null));
            }
            cont++;
        }
        
    }
    public String enviar() {
        return "usuarioAnyadirExito.xhtml?faces-redirect=true";
    }
    public String crearUsuario(){
        usuarios.add(new Usuario(getDni()));
        return "Usuario con DNI "+getDni()+ " creado con éxito.";
        //limpiar usuario?
    }
    
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    
    
    public void validarEmail(FacesContext context,UIComponent component,Object input) throws ValidatorException {
        String m = (String)input;
        System.out.print(m);
        if(!m.isEmpty()){
            if(!isValidEmailAddress(m)){
                
                throw new ValidatorException(
                        new FacesMessage("El email no es válido.", null));
            }
        }
        
    }
    
    
    
}

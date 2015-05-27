/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Actividad;
import entidades.Expediente;
import entidades.Persona;
import entidades.UTS;
import entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import negocio.UTSLocal;
import negocio.UsuarioLocal;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author DarkDragon
 */
@ManagedBean(name = "usuarioAnyadirBean")
@SessionScoped
public class usuarioAnyadirBean implements Serializable {

    private String text;
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
    private String tipoProfesional;
    private String contrasenya;
    private Long uts;
    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    /**
     * Creates a new instance of usuarios
     */
    /* public usuarioAnyadirBean(){
     usuarios = new ArrayList<Usuario>();
     usuarios.add(new Usuario("33333333P", "1234","Técnico"));
     usuarios.add(new Usuario("22222222J", "1234","Auxiliar administrativo"));
     usuarios.add(new Usuario("11111111H", "1234","Profesional"));
     }*/

    @EJB
    private UsuarioLocal ejb;

    private Usuario user;
    private Persona person;

    @ManagedProperty(value = "#{controlAutorizacion}")
    private ControlAutorizacion sesion;

    @PostConstruct
    public void init() {
        user = new Usuario();
        person = new Persona();
    }

    public void setSesion(ControlAutorizacion sesion) {
        this.sesion = sesion;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private String calcularDNI(String s) {
        String res = "error";
        String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            int n = Integer.parseInt(s);
            if (n < 0 || n > 99999999) {
                res = "error";
            } else {
                n = n % 23;
                res = letra.substring(n, n + 1);
            }
            return res;
        } catch (NumberFormatException nfe) {
            return "error";
        }
    }

    public void validarDni(FacesContext context, UIComponent component, Object input) throws ValidatorException {
        String var = (String) input;

        if (var.length() < 9) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Introduzca un DNI válido con una longitud igual a 9.", null));
        }
        if (!var.substring(8).equalsIgnoreCase(calcularDNI(var.substring(0, 8)))) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Introduzca un DNI válido.La letra no coincide", null));
        }
        //si ya existe el DNI

        for (Usuario useri : ejb.getUsuarios()) {
            if (useri.getDni().equalsIgnoreCase(var)) {
                throw new ValidatorException(
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El DNI introducido ya existe en la base de datos.", null));
            }
        }
    }

    public String enviar() {
        return "usuarioAnyadirExito.xhtml?faces-redirect=true";
    }

    public String crearUsuario() {

        //Persona p =new Persona(person.getDni(),person.getNombre(),person.getApellido1(),person.getApellido2(),person.getDireccion(),person.getTelefono(),person.getSexo(),person.getEstadoCivil(),person.getFechaNacimiento(),person.getLocalidad(),person.getNacionalidad(),person.getEmail());
        person.setDni(person.getDni().toUpperCase());
        user.setDni(person.getDni());
        user.setContrasena(sesion.sha256(user.getContrasena()));
        ejb.insertar(person);
        ejb.insertar(user);

        return "Usuario con DNI " + person.getDni() + " creado con éxito.";
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

    public void validarEmail(FacesContext context, UIComponent component, Object input) throws ValidatorException {
        String m = (String) input;
        System.out.print(m);
        if (!m.isEmpty()) {
            if (!isValidEmailAddress(m)) {

                throw new ValidatorException(
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El email no es válido.", null));
            }
        }

    }

    public void eliminar() {
        String dni1 = this.getSelectedUsuario().getDni();
        ejb.eliminar(this.getSelectedUsuario());
        ejb.eliminarP(this.getSelectedUsuario(), dni1);
        //return "usuarios.xhtml?faces-redirect=true";
    }

    public String aniadirselecionado() {
        System.out.println(selectedUsuario);
        sesion.setUsuarioSeleccionado(selectedUsuario);

        return "usuarioEditar.xhtml";
    }
    
    public String miPerfil(){
        sesion.setUsuarioSeleccionado(sesion.getUsuario());
        return "usuarioEditar.xhtml";
    }
    
    public void onRowSelect(SelectEvent event){
       selectedUsuario = (Usuario) event.getObject();
    }   

    public Long getUts() {
        return uts;
    }

    public void setUts(Long uts) {
        this.uts = uts;
    }

    public List<Usuario> listar() {
        return ejb.getUsuarios();
    }

}

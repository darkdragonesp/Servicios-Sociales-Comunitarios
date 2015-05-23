package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Robin
 */
@Entity
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DNI")
    private String dni;
    
    @Column(name="NOMBRE", nullable=false)
    private String nombre;
    
    @Column(name="APELLIDO_1",nullable=false)
    private String apellido1;
    
    @Column(name="APELLIDO_2")
    private String apellido2;
    
    @Column(name="DIRECCION", nullable=false)
    private String direccion;
    
    @Column(name="TELEFONO", nullable=false)
    private Integer telefono;
    
    @Column(name="SEXO", nullable=false)
    private Character sexo;
    
    @Column(name="ESTADO_CIVIL", nullable=false)
    private String estadoCivil;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_NACIMIENTO", nullable=false)
    private Date fechaNacimiento;
    
    @Column(name="LOCALIDAD", nullable=false)
    private String localidad;
    
    @Column(name="NACIONALIDAD", nullable=false)
    private String nacionalidad;
    
    @Column(name="EMAIL")
    private String email;
    
    @OneToOne(mappedBy="persona")
    private Ciudadano ciudadano;
    
    @OneToOne(mappedBy="persona")
    private Usuario usuario;
    
    public Persona() { }
    
    public Persona (String dni, String nombre, String apellido1, String apellido2) {
        this.dni=dni;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", telefono=" + telefono + ", sexo=" + sexo + ", estado_civil=" + estadoCivil + ", fecha_nacimiento=" + fechaNacimiento + ", localidad=" + localidad + ", nacionalidad=" + nacionalidad + ", email=" + email + '}';
    }
}

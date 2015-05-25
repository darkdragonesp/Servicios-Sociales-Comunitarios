package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Robin
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="DNI")
    private String dni;
    
    @Column(name="TIPO_PROFESIONAL", nullable=false)
    private String tipoProfesional;
    
    @Column(name="CONTRASENA", nullable=false)
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name="UTS", referencedColumnName="ID_UTS", nullable = false)
    private UTS uts;
    
    @OneToOne
    @JoinColumn(name="DNI", referencedColumnName="DNI", insertable=false, updatable=false)
    private Persona persona;
    
    @OneToMany(mappedBy = "usuario")
    private List<Actividad> actividades;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,  CascadeType.REMOVE})
    @JoinTable(name = "ACCESO_EXPEDIENTES", 
            joinColumns = @JoinColumn(name = "USUARIO"), 
            inverseJoinColumns = @JoinColumn(name = "EXPEDIENTE"))
    private List<Expediente> expedientes;
    
    
    public Usuario(){
        this.persona = new Persona();
    }

    public Usuario(String dni, String pass){
        setDni(dni);
        this.persona = new Persona();
        contrasena = pass;
    }
    public Usuario(String dni, String pass, String tipo_profesional){
        setDni(dni);
        setContrasena(pass);
        this.persona = new Persona();
        setTipoProfesional(tipo_profesional);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    
    public String getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(String tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UTS getUts() {
        return uts;
    }

    public void setUts(UTS uts) {
        this.uts = uts;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.dni);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", tipoProfesional=" + tipoProfesional + ", contrasena=" + contrasena + ", uts=" + uts + ", persona=" + persona + '}';
    }
    
    

    
}

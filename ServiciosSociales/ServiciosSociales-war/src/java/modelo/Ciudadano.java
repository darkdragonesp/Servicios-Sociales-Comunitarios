package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Robin
 */

@Entity
public class Ciudadano implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="DNI")
    private String dni;
    
    @ManyToOne
    @JoinColumn(name="EXPEDIENTE", referencedColumnName="ID_EXPEDIENTE", nullable=false)
    private Expediente expediente;

    @OneToMany(mappedBy="ciudadano1")
    private List<Parentesco> parentescos1;
    @OneToMany(mappedBy="ciudadano2")
    private List<Parentesco> parentescos2;
    
    @OneToOne
    @JoinColumn(name="DNI", referencedColumnName="DNI", insertable=false, updatable=false)
    private Persona persona;
    
    public Ciudadano(){}
    
    public Ciudadano(String dni, String nombre, String apellido1, String apellido2) {
        this.persona = new Persona(dni, nombre, apellido1, apellido2);
        this.dni=dni;
        this.persona.setCiudadano(this);
    }
    
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public List<Parentesco> getParentescos1() {
        return parentescos1;
    }

    public void setParentescos1(List<Parentesco> parentescos1) {
        this.parentescos1 = parentescos1;
    }

    public List<Parentesco> getParentescos2() {
        return parentescos2;
    }

    public void setParentescos2(List<Parentesco> parentescos2) {
        this.parentescos2 = parentescos2;
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

    @Override
    public String toString() {
        return "Ciudadano{" + "dni=" + dni + ", expediente=" + expediente + ", parentescos1=" + parentescos1 + ", parentescos2=" + parentescos2 + ", persona=" + persona + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Ciudadano other = (Ciudadano) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
}

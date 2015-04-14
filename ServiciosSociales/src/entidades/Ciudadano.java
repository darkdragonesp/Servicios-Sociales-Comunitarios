package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Robin
 */

@Entity
@Table(name = "CIUDADANO")
public class Ciudadano implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="DNI")
    private String dni;
    
    @ManyToOne
    @JoinColumn(name="EXPEDIENTE_ID_EXPEDIENTE", referencedColumnName="ID_EXPEDIENTE", nullable=false)
    private Expediente expediente;

    @OneToMany(mappedBy="ciudadano1")
    private List<Parentesco> parentescos1;
    @OneToMany(mappedBy="ciudadano2")
    private List<Parentesco> parentescos2;
    
    @OneToOne
    @JoinColumn(name="DNI", referencedColumnName="DNI", insertable=false, updatable=false)
    private Persona persona;
    
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.expediente);
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
        if (!Objects.equals(this.expediente, other.expediente)) {
            return false;
        }
        return true;
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
        return "Ciudadano{" + "dni=" + dni + '}';
    }

}

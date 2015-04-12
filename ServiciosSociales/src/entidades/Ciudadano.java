package entidades;

import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Robin
 */

@Entity
@Table(name = "CIUDADANO")
@DiscriminatorValue("C")
public class Ciudadano extends Persona {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="EXPEDIENTE_ID_EXPEDIENTE", referencedColumnName="ID_EXPEDIENTE", nullable=false)
    private Expediente expediente;

    @OneToMany(mappedBy="ciudadano1")
    private List<Parentesco> parentescos1;
    @OneToMany(mappedBy="ciudadano2")
    private List<Parentesco> parentescos2;
    
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


    
    
}

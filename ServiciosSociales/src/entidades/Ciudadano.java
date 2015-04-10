package entidades;

import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Robin
 */

@Entity
@DiscriminatorValue("CIUDADANO")
public class Ciudadano extends Persona {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Expediente ciudadano_TO_id_expediente;

    @OneToMany(mappedBy="ciudadano1")
    private List<Parentesco> parentescos1;
    @OneToMany(mappedBy="ciudadano2")
    private List<Parentesco> parentescos2;
    
    public Expediente getCiudadano_TO_id_expediente() {
        return ciudadano_TO_id_expediente;
    }

    public void setCiudadano_TO_id_expediente(Expediente ciudadano_TO_id_expediente) {
        this.ciudadano_TO_id_expediente = ciudadano_TO_id_expediente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ciudadano_TO_id_expediente);
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
        if (!Objects.equals(this.ciudadano_TO_id_expediente, other.ciudadano_TO_id_expediente)) {
            return false;
        }
        return true;
    }


    
    
}

package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Robin
 */

@Entity
@DiscriminatorValue("C")
public class Ciudadano extends Persona {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="ciudadano_TO_id_expediente", nullable=false)
    private Expediente expediente;

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }
    
    
    
}

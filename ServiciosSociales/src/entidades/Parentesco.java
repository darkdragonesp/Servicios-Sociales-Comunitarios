package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JuanJo
 */
@Entity
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    private Ciudadano c1;
    
    @Id
    @ManyToOne
    private Ciudadano c2;
    
    private String tipo_parentesco;

    
    

    public Ciudadano getC1() {
        return c1;
    }

    public void setC1(Ciudadano c1) {
        this.c1 = c1;
    }

    public Ciudadano getC2() {
        return c2;
    }

    public void setC2(Ciudadano c2) {
        this.c2 = c2;
    }

    public String getTipo_parentesco() {
        return tipo_parentesco;
    }

    public void setTipo_parentesco(String tipo_parentesco) {
        this.tipo_parentesco = tipo_parentesco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.c1);
        hash = 29 * hash + Objects.hashCode(this.c2);
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
        final Parentesco other = (Parentesco) obj;
        if (!Objects.equals(this.c1, other.c1)) {
            return false;
        }
        if (!Objects.equals(this.c2, other.c2)) {
            return false;
        }
        return true;
    }
    
    

}

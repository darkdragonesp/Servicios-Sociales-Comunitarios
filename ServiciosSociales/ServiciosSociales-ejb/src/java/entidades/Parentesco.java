package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author FranciscoJosé
 */
@Entity
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParentescoID parentescoPK;
    @Column(name = "PARENTESCO",nullable =false)
    private String parentesco;
    @JoinColumn(name = "CIUDADANO1", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano1;
    @JoinColumn(name = "CIUDADANO2", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudadano ciudadano2;
    
    public Parentesco() { }
    
    public Parentesco(String dni1, String dni2, String parentesco) {
        this.parentescoPK = new ParentescoID(dni1,dni2);
        this.parentesco = parentesco;
    }

    public Parentesco(ParentescoID parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public Parentesco(String ciudadanoDni, String ciudadanoDni1) {
        this.parentescoPK = new ParentescoID(ciudadanoDni, ciudadanoDni1);
    }

    public ParentescoID getParentescoPK() {
        return parentescoPK;
    }

    public void setParentescoPK(ParentescoID parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Ciudadano getCiudadano1() {
        return ciudadano1;
    }

    public void setCiudadano1(Ciudadano ciudadano1) {
        this.ciudadano1 = ciudadano1;
    }

    public Ciudadano getCiudadano2() {
        return ciudadano2;
    }

    public void setCiudadano2(Ciudadano ciudadano2) {
        this.ciudadano2 = ciudadano2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentescoPK != null ? parentescoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.parentescoPK == null && other.parentescoPK != null) || (this.parentescoPK != null && !this.parentescoPK.equals(other.parentescoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parentesco{" + "parentescoPK=" + parentescoPK + ", parentesco=" + parentesco + ", ciudadano1=" + ciudadano1 + ", ciudadano2=" + ciudadano2 + '}';
    }




    
}

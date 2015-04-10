package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JuanJo
 */
@Entity
public class UTS implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_uts;
    
    private String id_zona;
    private String id_css;

    public Long getId() {
        return id_uts;
    }

    public void setId(Long id) {
        this.id_uts = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_uts != null ? id_uts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UTS)) {
            return false;
        }
        UTS other = (UTS) object;
        if ((this.id_uts == null && other.id_uts != null) || (this.id_uts != null && !this.id_uts.equals(other.id_uts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UTS[ id=" + id_uts + " ]";
    }
    
}

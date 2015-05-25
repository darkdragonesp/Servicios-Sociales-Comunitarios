package entidades;

import java.io.Serializable;
import javax.persistence.Column;
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
    @Column(name="ID_UTS")
    private Long id;
    
    @Column(name="UTS", nullable=false)
    private String uts;
    
    @Column(name="ZONA", nullable=false)
    private String zona;
    
    @Column(name="CSS", nullable=false)
    private String css;
    
    public UTS(){
        
    }
    /*public UTS(Long id,String uts,String z,String c){
        setUts(uts);
        setId(id);
        setCss(c);
        setZona(z);
    }*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getUts() {
        return uts;
    }

    public void setUts(String uts) {
        this.uts = uts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UTS)) {
            return false;
        }
        UTS other = (UTS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UTS{" + "id=" + id + ", uts=" + uts + ", zona=" + zona + ", css=" + css + '}';
    }


    
}

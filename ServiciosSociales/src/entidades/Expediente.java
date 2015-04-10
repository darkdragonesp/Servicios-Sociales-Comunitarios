package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FranciscoJosé
 */
@Entity
public class Expediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id_expediente")
    private Long id;
    
    @Column(name="fecha_apertura", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    
    @Column(name="fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="Expediente_id_expediente", referencedColumnName="id_expediente")
    private Expediente expedienteLigado;
    
    @ManyToOne
    @JoinColumn(name="id_uts", referencedColumnName="id_uts", nullable=false)
    private UTS uts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getFechaApertura() {
        return fechaApertura;
    }
    
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
    public Date getFechaCierre() {
        return fechaCierre;
    }
    
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*public Expediente getExpedienteLigado() {
        return expedienteLigado;
    }

    public void setExpedienteLigado(Expediente expedienteLigado) {
        this.expedienteLigado = expedienteLigado;
    }*/

    /*public UTS getUts() {
        return uts;
    }

    public void setUts(UTS uts) {
        this.uts = uts;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Expediente[ id=" + id + " ]";
    }
    
}

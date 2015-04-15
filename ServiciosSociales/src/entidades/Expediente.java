package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Column(name="ID_EXPEDIENTE")
    private Long id;
    
    @Column(name="FECHA_APERTURA", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    
    @Column(name="FECHA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    
    @Column(name="ESTADO",nullable=false)
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="EXPEDIENTE_RELACIONADO", referencedColumnName="ID_EXPEDIENTE")
    private Expediente expedienteLigado;
   
    @OneToMany(mappedBy = "expedienteLigado")
    private List<Expediente> expedientesLigados;
    
    @ManyToOne
    @JoinColumn(name="UTS", referencedColumnName="ID_UTS", nullable = false)
    private UTS uts;
    
    @OneToMany(mappedBy = "expediente")
    private List<Ciudadano> ciudadanos;
    
    @OneToMany(mappedBy = "expediente")
    private List<Intervencion> intervenciones;

    public List<Expediente> getExpedientesLigados() {
        return expedientesLigados;
    }

    public void setExpedientesLigados(List<Expediente> expedientesLigados) {
        this.expedientesLigados = expedientesLigados;
    }

    public List<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervencion> intervenciones) {
        this.intervenciones = intervenciones;
    }

    public List<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(List<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
    
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

    public Expediente getExpedienteLigado() {
        return expedienteLigado;
    }

    public void setExpedienteLigado(Expediente expedienteLigado) {
        this.expedienteLigado = expedienteLigado;
    }

    public UTS getUts() {
        return uts;
    }

    public void setUts(UTS uts) {
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
        return "Expediente{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", estado=" + estado + ", expedienteLigado=" + expedienteLigado + ", expedientesLigados=" + expedientesLigados + ", uts=" + uts + ", ciudadanos=" + ciudadanos + ", intervenciones=" + intervenciones + '}';
    }


}

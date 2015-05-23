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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JuanJo
 */
@Entity
public class Intervencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_INTERVENCION")
    private Long id;
    
    @Column(name="FECHA_INICIO", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name="FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name="VALORACION", nullable=false)
    private String valoracion;
    
    @Column(name="TIPO", nullable=false)
    private String tipo;
    
    @Column(name="RECURSO_APLICADO")
    private String recursoAplicado;
    
    @Column(name="RECURSO_IDEAL")
    private String recursoIdeal;
    
    @Column(name="AYUDA")
    private String ayuda;
    
    @Column(name="NOTAS")
    private String notas;
    
    @OneToOne
    @JoinColumn(name="ACTIVIDAD", referencedColumnName="ID_ACTIVIDAD", nullable = false)
    private Actividad actividad;
    
    @ManyToOne
    @JoinColumn(name="EXPEDIENTE", referencedColumnName="ID_EXPEDIENTE", nullable = false)
    private Expediente expediente;
    
    public Intervencion(){
        
    }
    
    public Intervencion(Intervencion intervencion){
        setId(intervencion.getId());
        setTipo(intervencion.getTipo());
        setRecursoAplicado(intervencion.getRecursoAplicado());
        setRecursoIdeal(intervencion.getRecursoIdeal());
        setAyuda(intervencion.getAyuda());
        setFechaInicio(intervencion.getFechaInicio());
        setFechaFin(intervencion.getFechaFin());
        setNotas(intervencion.getNotas());
        setValoracion(intervencion.getValoracion());
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecursoAplicado() {
        return recursoAplicado;
    }

    public void setRecursoAplicado(String recursoAplicado) {
        this.recursoAplicado = recursoAplicado;
    }

    public String getRecursoIdeal() {
        return recursoIdeal;
    }

    public void setRecursoIdeal(String recursoIdeal) {
        this.recursoIdeal = recursoIdeal;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
        if (!(object instanceof Intervencion)) {
            return false;
        }
        Intervencion other = (Intervencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Intervencion{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", valoracion=" + valoracion + ", tipo=" + tipo + ", recursoAplicado=" + recursoAplicado + ", recursoIdeal=" + recursoIdeal + ", ayuda=" + ayuda + ", notas=" + notas + ", actividad=" + actividad + ", expediente=" + expediente + '}';
    }


}

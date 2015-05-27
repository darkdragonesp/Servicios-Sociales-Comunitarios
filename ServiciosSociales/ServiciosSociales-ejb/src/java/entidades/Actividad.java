package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Fran Molina
 */
@Entity
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_ACTIVIDAD")
    //private Long id;
    private String id;
    @Column(name="LUGAR", nullable=true, length=50)
    private String lugar;
    @Column(name="FECHA", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name="HORA", nullable=true)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name="DESCRIPCION", nullable=true, length=200)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name="USUARIO_DNI", referencedColumnName="DNI", nullable = false)
    private Usuario usuario;
    
    @OneToOne(mappedBy = "actividad")
    private Intervencion intervencion;
    
    public Actividad(){
        
    }
    
    public Actividad(String descripcion, Date fecha){
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    public Actividad(String descripcion, Date fecha, Date hora, String lugar){
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Intervencion getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(Intervencion intervencion) {
        this.intervencion = intervencion;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", lugar=" + lugar + ", fecha=" + fecha + ", hora=" + hora + ", descripcion=" + descripcion + ", usuario=" + usuario + '}';
    }

}

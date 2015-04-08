/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SS.Modelos;

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
    private Long id;
    @Column(nullable=false, length=50)
    private String lugar;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(nullable=false)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(nullable=true, length=200)
    private String descripcion;
    //Relacion 1to1 con Intervencion
    private Intervencion inter;
    //Relacion MuchosaMuchos con USUARIO
    @ManyToMany(mappedBy= "ActividadPorUsuario")
    
    
    //METER EN LA ENTIDAD USUARIO
    /*
    
    @JoinTable(name="UsuarioYActividad",joinColumns = @JoinColumn(name= "usuario_fk"),
    inverseJoinColumns= @JoinColumn(name= "Actividad_fk"))
    private List<Actividad> ActividadPorUsuario;
    
    
    
    
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Intervencion getInter() {
        return inter;
    }

    public void setInter(Intervencion inter) {
        this.inter = inter;
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
        return "SS.Modelos.Actividad[ id=" + id + " ]";
    }
    
}

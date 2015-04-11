package entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Portátil
 */
@Entity
@Table(name = "USUARIO")
@DiscriminatorValue("U")
public class Usuario extends Persona {
    private static final long serialVersionUID = 1L;
    
    @Column(name="TIPO_PROFESIONAL", nullable=false)
    private String tipoProfesional;
    @Column(name="CONTRASENA", nullable=false)
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name="UTS_ID_UTS", referencedColumnName="ID_UTS", nullable = false)
    private UTS uts;
    
    @OneToMany(mappedBy = "usuario")
    private List<Actividad> actividades;
    
    public String getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(String tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UTS getUts() {
        return uts;
    }

    public void setUts(UTS uts) {
        this.uts = uts;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}

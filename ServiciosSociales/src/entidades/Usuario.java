package entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Portátil
 */
@Entity
@DiscriminatorValue("USUARIO")
public class Usuario extends Persona {
    private static final long serialVersionUID = 1L;
    
    @Column(nullable=false)
    private String tipo_profesional;
    @Column(nullable=false)
    private String contraseña;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private UTS usuario_TO_id_uts;
    
    @OneToMany(mappedBy = "usuario")
    private List<Actividad> actividades;
    
    @OneToMany(mappedBy = "id_to_usuario")
    private List<Expediente> expedientes;
    
    public String getTipo_profesional() {
        return tipo_profesional;
    }

    public void setTipo_profesional(String tipo_profesional) {
        this.tipo_profesional = tipo_profesional;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    
}

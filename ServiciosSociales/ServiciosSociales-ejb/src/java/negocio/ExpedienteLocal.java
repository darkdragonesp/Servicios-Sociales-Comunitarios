package negocio;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.Intervencion;
import entidades.UTS;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frasc_000
 */
@Local
public interface ExpedienteLocal {
    //Metodos Juanjo
    public boolean insertar(Expediente expediente);
    public boolean modificar(Expediente expediente);
    public boolean eliminar(Expediente expediente);
    public Expediente refrescarExpediente(Expediente expediente);
    
    //Metodos Paco
    public void insertarExpediente(Expediente expediente);
    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano);
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano);
    public void modificarExpediente(Expediente expediente);
    public Expediente getExpediente(long id);
    public List<Expediente> getExpedientes();
    public List<Intervencion> getIntervenciones();
    public List<UTS> getUtss();
}

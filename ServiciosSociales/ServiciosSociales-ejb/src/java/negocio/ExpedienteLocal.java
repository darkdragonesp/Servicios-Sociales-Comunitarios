package negocio;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.UTS;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frasc_000
 */
@Local
public interface ExpedienteLocal {
    public void insertarExpediente(Expediente expediente);
    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano);
    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano);
    public void modificarExpediente(Expediente expediente);
    public Expediente getExpediente(long id);
    public void refrescarExpediente(Expediente expediente);
    public List<Expediente> getExpedientes();
    public List<UTS> getUtss();
}

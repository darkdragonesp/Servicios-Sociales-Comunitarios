package negocio;

import entidades.Expediente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuanJo
 */
@Local
public interface ExpedienteLocal {
    public boolean insertar(Expediente expediente);
    public boolean modificar(Expediente expediente);
    public boolean eliminar(Expediente expediente);
    public List<Expediente> getExpedientes();
}

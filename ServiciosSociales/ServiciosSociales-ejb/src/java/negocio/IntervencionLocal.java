package negocio;

import entidades.Intervencion;
import javax.ejb.Local;

/**
 *
 * @author JuanJo
 */
@Local
public interface IntervencionLocal {
    public boolean insertar(Intervencion intervencion);
    public boolean modificar(Intervencion intervencion);
    public boolean eliminar(Intervencion intervencion);
}

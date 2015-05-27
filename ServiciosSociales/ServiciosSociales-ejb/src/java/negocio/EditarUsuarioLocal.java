package negocio;

import entidades.Persona;
import entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Robin
 */
@Local
public interface EditarUsuarioLocal {
    public boolean insertar(Usuario user);
    public boolean modificar(Usuario user);
    public boolean eliminar(Usuario user);
    public boolean modificarP(Persona p);
}

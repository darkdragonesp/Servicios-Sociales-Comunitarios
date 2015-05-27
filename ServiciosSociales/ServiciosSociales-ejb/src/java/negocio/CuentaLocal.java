package negocio;

import entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author JuanJo
 */
@Local
public interface CuentaLocal {
    public Usuario refrescarUsuario(Usuario usuario);
    public boolean comprobarLogin();
}

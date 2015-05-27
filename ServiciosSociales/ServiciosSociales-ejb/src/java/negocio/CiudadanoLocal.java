package negocio;

import entidades.Ciudadano;
import entidades.Parentesco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frasc_000
 */
@Local
public interface CiudadanoLocal {
    public void insertarCiudadano(Ciudadano ciudadano);
    public void modificarCiudadano(Ciudadano ciudadano);
    public List<Ciudadano> getCiudadanos();
    public Ciudadano getCiudadano(String dni);
    public void insertarParentesco(Parentesco parentesco1, Parentesco parentesco2);
    public void eliminarParentesco(Ciudadano ciudadano1, Ciudadano ciudadano2);
    public void eliminarParentesco(Parentesco parentesco);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidades.Usuario;
import entidades.Actividad;
import javax.ejb.Local;

/**
 *
 * @author Laura
 */
@Local
public interface ActividadLocal {
    public boolean actualizarUsuario(Usuario usuario);
    public boolean actualizarActividad(Actividad actividad);
    public boolean insertarActividad(Actividad actividad);
    public boolean borrarActividad(Actividad actividad);
}

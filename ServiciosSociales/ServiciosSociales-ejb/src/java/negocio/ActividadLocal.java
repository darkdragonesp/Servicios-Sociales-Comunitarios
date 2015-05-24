/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Laura
 */
@Local
public interface ActividadLocal {
    public boolean actualizar(Usuario usuario);
   
}

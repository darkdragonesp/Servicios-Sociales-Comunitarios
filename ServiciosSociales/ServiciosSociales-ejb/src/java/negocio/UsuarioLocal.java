/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Persona;
import entidades.UTS;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkDragon
 */
@Local
public interface UsuarioLocal {
    public List<Usuario> getUsuarios();
    public boolean insertar(Usuario u);
    public boolean eliminar(Usuario u);
    public boolean editar(Usuario u);

    public boolean insertar(Persona p);
     public List<UTS> getUTSs();

    public List<Persona> getPersonas();

    public void eliminarP(Usuario selectedUsuario, String dni);
}

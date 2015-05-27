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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DarkDragon
 */
@Stateless
public class UsuarioEJB implements UsuarioLocal{
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public List<Usuario> getUsuarios() {
        return em.createQuery("SELECT a FROM Usuario a", Usuario.class).getResultList();
    }
    
    @Override
    public boolean insertar(Usuario u) {
        if (u == null) return false;
        try {
            em.persist(u);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean eliminar(Usuario u) {
        if (u == null) return false;
        try {
            em.remove(em.merge(u));
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean editar(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insertar(Persona u) {
        if (u == null) return false;
        try {
            em.persist(u);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    @Override
    public List<UTS> getUTSs() {
         return em.createQuery("SELECT a FROM UTS a", UTS.class).getResultList();
    }

    @Override
    public List<Persona> getPersonas() {
         return em.createQuery("SELECT a FROM Persona a", Persona.class).getResultList();
    }

    @Override
    public void eliminarP(Usuario selectedUsuario, String dni) {
        Query q = em.createQuery("SELECT p FROM Persona p WHERE p.dni = :d", Persona.class);
            q.setParameter("d", dni);
            Object p=q.getSingleResult();
           // System.out.println(p);
            
            em.remove(em.merge(p));
    }

    @Override
    public boolean PersonaExiste(Persona person) {
        return em.find(Persona.class, person.getDni())!=null;
    }

    @Override
    public void actualizaPersona(Persona person) {
        Persona p =em.find(Persona.class, person.getDni());
        p.setApellido1(person.getApellido1());
        p.setApellido2(person.getApellido2());
        p.setDireccion(person.getDireccion());
        p.setEmail(person.getEmail());
        p.setEstadoCivil(person.getEstadoCivil());
        p.setFechaNacimiento(person.getFechaNacimiento());
        p.setLocalidad(person.getNacionalidad());
        p.setNacionalidad(person.getNacionalidad());
        p.setNombre(person.getNombre());
        p.setSexo(person.getSexo());
        p.setTelefono(person.getTelefono());
    }

    @Override
    public void eliminarAccesoExpediente(String dni1) {
        /*Query q = em.createQuery("SELECT p FROM ACCESO_EXPEDIENTES p");
            //q.setParameter("d", dni1);
            Object p=q.getSingleResult();
             em.remove(em.merge(p));
    */}
}

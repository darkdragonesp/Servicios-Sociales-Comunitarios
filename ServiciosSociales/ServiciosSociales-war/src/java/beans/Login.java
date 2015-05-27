package beans;

import entidades.Usuario;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.CuentaLocal;

/**
 *
 * @author Portátil
 */

@ManagedBean(name = "login")
@RequestScoped
public class Login implements Serializable {
    private Usuario usuario;

    /*@ManagedProperty(value = "#{datosFicticios}")
    private DatosFicticios datos;*/
    
    @ManagedProperty(value = "#{controlAutorizacion}")
    private ControlAutorizacion sesion;
    
    @EJB
    private CuentaLocal cuenta;
    
    public Login(){
        
    }
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void setSesion(ControlAutorizacion sesion) {
        this.sesion = sesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String autenticar(){
        
        Usuario user = cuenta.refrescarUsuario(usuario);
        
        if(user == null || !user.getContrasena().equalsIgnoreCase(sha256(usuario.getContrasena()))){
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El usuario y/o contraseña es incorrecto"));
        }else
            sesion.setUsuario(user);
        
        return sesion.redireccionar();
    }
    
    public String sha256(String s){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
        byte[] mdbytes = md.digest(s.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
}

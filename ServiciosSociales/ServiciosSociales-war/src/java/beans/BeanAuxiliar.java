/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Ciudadano;
import entidades.Expediente;
import entidades.Parentesco;
import entidades.ParentescoID;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BeanAuxiliar {
//    public List<Parentesco> getParentescos() {
//        return parentescos;
//    }
//
//    public void setParentescos(List<Parentesco> parentescos) {
//        this.parentescos = parentescos;
//    }
//    
//    public Ciudadano obtenerCiudadano(String dni) {
//        for (Ciudadano ciudadano : this.ciudadanos) {
//            if(ciudadano.getDni().equals(dni)) return ciudadano;
//        }
//        return null;
//    }
//    
//    public Expediente obtenerExpediente(String id) {
//        for (Expediente expediente : this.expedientes) {
//            if (expediente.getId().equals(id)) return expediente;
//        }
//        return null;
//    }
//    
//    public Parentesco obtenerParentesco(Ciudadano ciudadano, Ciudadano pariente) {
//        List<Parentesco> parentescos = ciudadano.getParentescos();
//        for (Parentesco parentesco : parentescos) {
//            if (parentesco.getCiudadano2().getDni().equals(pariente.getDni())) return parentesco;
//        }
//        return null;
//    }
//    
//    public void eliminarCiudadano(Expediente expediente, Ciudadano ciudadano) {
//        expediente.getCiudadanos().remove(ciudadano);
//    }
//    
//    public void eliminarParentesco(Ciudadano ciudadano, Ciudadano pariente) {
//        pariente.getParentescos().remove(obtenerParentesco(pariente, ciudadano));
//        ciudadano.getParentescos().remove(obtenerParentesco(ciudadano, pariente));
//    }
//    
//    public void anadirParentesco(Ciudadano ciudadano, Ciudadano pariente, String parentescoSeleccionado1, String parentescoSeleccionado2) {
//        System.out.println("Entrada ciudadano: "+ciudadano);
//        System.out.println("Entrada pariente: "+pariente);
//        Parentesco parentesco = new Parentesco();
//        parentesco.setCiudadano1(ciudadano);
//        parentesco.setCiudadano2(pariente);
//        parentesco.setParentesco(parentescoSeleccionado1);
//        parentesco.setParentescoPK(new ParentescoID(ciudadano.getDni(), pariente.getDni()));
//        List<Parentesco> parentescos = ciudadano.getParentescos();
//        if (parentescos==null) parentescos=new ArrayList<>();
//        parentescos.add(parentesco);
//        ciudadano.setParentescos(parentescos);
//        Parentesco parentesco2 = new Parentesco();
//        parentesco2.setCiudadano1(pariente);
//        parentesco2.setCiudadano2(ciudadano);
//        parentesco2.setParentesco(parentescoSeleccionado2);
//        parentesco2.setParentescoPK(new ParentescoID(pariente.getDni(), ciudadano.getDni()));
//        List<Parentesco> parentescos2 = pariente.getParentescos();
//        if (parentescos2==null) parentescos2=new ArrayList<>();
//        parentescos2.add(parentesco2);
//        pariente.setParentescos(parentescos2);
//        this.parentescos.add(parentesco);
//        this.parentescos.add(parentesco2);
//    }
//    
//    public void anadirCiudadano(Expediente expediente, Ciudadano ciudadano) {
////        List<Ciudadano> ciudadanos = expediente.getCiudadanos();
////        if (ciudadanos==null) ciudadanos = new ArrayList<Ciudadano>();
////        ciudadanos.add(ciudadano);
////        if (ciudadano.getExpediente().getCiudadanos()!=null) {
////            ciudadano.getExpediente().getCiudadanos().remove(ciudadano);
////        }
////        ciudadano.setExpediente(expediente);
////        expediente.setCiudadanos(ciudadanos);
//        ciudadano.setExpediente(expediente);
//        ciudadanoEJB.modificarCiudadano(ciudadano);
//    }
//    
//    public String crearCiudadano(Ciudadano ciudadano, Expediente expediente) {
//        this.ciudadanos.add(ciudadano);
//        if (expediente!=null) {
//            anadirCiudadano(expediente, ciudadano);
//        }
//        return "expedientes.xhtml";
//    }
//    
//    public String crearExpediente(Expediente expediente) {
//        this.expedientes.add(expediente);
//        return "expedientes.xhtml";
//    }
}

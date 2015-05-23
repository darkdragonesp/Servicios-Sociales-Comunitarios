/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import entidades.UTS;
import negocio.UTSLocal;
/**
 *
 * @author DarkDragon
 */
@ManagedBean
@SessionScoped
public class utsBean  implements Serializable{
    private Long id;
    private String uts;
    private String zona;
    private String css;
    
    private List<UTS> utss;
    private UTS selectedUTS;
    
    
    private UTS uts1;
  @EJB
    private UTSLocal ejb;
    
    public utsBean(){}
  
    @ManagedProperty(value = "#{datosFicticios}")
    private DatosFicticios datos;

    public void setDatos(DatosFicticios datos) {
        this.datos = datos;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUts() {
        return uts;
    }

    public void setUts(String uts) {
        this.uts = uts;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public List<UTS> getUtss() {
        return utss;
    }

    public void setUtss(List<UTS> utss) {
        this.utss = utss;
    }

    public UTS getSelectedUTS() {
        return selectedUTS;
    }

    public void setSelectedUTS(UTS selectedUTS) {
        this.selectedUTS = selectedUTS;
    }
     public void eliminar(){
        //datos.getUts().remove(this.getSelectedUTS());
//       return "usuarios.xhtml?faces-redirect=true";
    }
public String enviar() {
        return "utsAnyadirExito.xhtml?faces-redirect=true";
    }
    public String crearUTS(){
        long ide=0;
        if(! ejb.getUTSs().isEmpty()){
            ide=( ejb.getUTSs().get( ejb.getUTSs().size()-1).getId())+1;
        }
        setId(ide);
       // datos.getUts().add(new UTS(ide,getUts(),getZona(),getCss()));
        
        ejb.insertar(new UTS(ide,getUts(),getZona(),getCss()));
        return "UTS "+getUts()+ "con id "+id+" creado con éxito .";
        
    }
}

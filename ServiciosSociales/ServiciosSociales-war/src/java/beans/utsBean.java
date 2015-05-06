/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.UTS;
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
    
   /* public utsBean(){
        utss = new ArrayList<UTS>();
        utss.add(new UTS((long)1,"Sur","El Palo","Malaga"));
        utss.add(new UTS((long)2,"Norte","Teatinos","Malaga"));
        utss.add(new UTS((long)3,"Centro","Antequera","Malaga"));
    }*/
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
        datos.getUts().remove(this.getSelectedUTS());
//       return "usuarios.xhtml?faces-redirect=true";
    }
public String enviar() {
        return "utsAnyadirExito.xhtml?faces-redirect=true";
    }
    public String crearUTS(){
        long ide=0;
        if(! datos.getUts().isEmpty()){
            ide=( datos.getUts().get( datos.getUts().size()-1).getId())+1;
        }
        setId(ide);
        datos.getUts().add(new UTS(ide,getUts(),getZona(),getCss()));
        return "UTS "+getUts()+ "con id "+id+" creado con éxito .";
        //limpiar uts?
    }
}

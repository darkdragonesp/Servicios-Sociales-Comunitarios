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
import javax.faces.bean.SessionScoped;
import modelo.UTS;
/**
 *
 * @author DarkDragon
 */
@ManagedBean
@SessionScoped
public class utsBean  implements Serializable{
    private long id;
    private String uts;
    private String zona;
    private String css;
    
    private List<UTS> utss;
    private UTS selectedUTS;
    
    public utsBean(){
        utss = new ArrayList<UTS>();
        utss.add(new UTS((long)1,"33333333P"));
        utss.add(new UTS((long)2,"22222222J"));
        utss.add(new UTS((long)3,"11111111H"));
    }
    public UTS getSelectedUTS() {
        return selectedUTS;
    }
    public void setSelectedUsuario(UTS selectedUTS) {
        this.selectedUTS=selectedUTS;
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
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public String enviar() {
        return "utsAnyadirExito.xhtml?faces-redirect=true";
    }
    public String crearUTS(){
        long id=0;
        if(!utss.isEmpty()){
            id=(utss.get(utss.size()-1).getId())+1;
        }
        setId(id);
        utss.add(new UTS(id,getUts()));
        return "UTS "+getUts()+ "con id "+id+" creado con éxito .";
        //limpiar uts?
    }
    public String eliminar(){
        utss.remove(0);
//utss.remove(this.getSelectedUTS());
        return "utss.xhtml?faces-redirect=true";
    }
}

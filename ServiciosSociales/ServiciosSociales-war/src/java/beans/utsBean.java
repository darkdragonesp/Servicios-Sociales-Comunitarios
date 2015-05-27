/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package beans;

import entidades.UTS;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import negocio.ExpedienteLocal;
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
    @EJB
    private ExpedienteLocal expedienteEJB;
    
    public utsBean(){}
    
    @PostConstruct
    public void init(){
        uts1=new UTS();
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
        this.utss = expedienteEJB.getUtss();
        return utss;
    }
    public UTS getSelectedUTS() {
        return selectedUTS;
    }
    
    public void setSelectedUTS(UTS selectedUTS) {
        this.selectedUTS = selectedUTS;
    }
    public void eliminar(){
        //datos.getUts().remove(this.getSelectedUTS());
        ejb.eliminar(this.getSelectedUTS());
//       return "usuarios.xhtml?faces-redirect=true";
    }
    public String enviar() {
        return "utsAnyadirExito.xhtml?faces-redirect=true";
    }
    public String crearUTS(){
        Long ide=new Long("0");
        if(! ejb.getUTSs().isEmpty()){
            ide=( ejb.getUTSs().get( ejb.getUTSs().size()-1).getId())+1;
        }
        
        uts1.setId(ide);
        // datos.getUts().add(new UTS(ide,getUts(),getZona(),getCss()));
        ejb.insertar(uts1);
        //ejb.insertar(new UTS(ide,getUts(),getZona(),getCss()));
        return "UTS "+uts1.getUts()+ "con id "+uts1.getId()+" creado con éxito .";
        
    }
    public List<UTS> listar(){
        return ejb.getUTSs();
    }

 

    public void setId(Long id) {
        this.id = id;
    }

    public UTS getUts1() {
        return uts1;
    }

    public void setUts1(UTS uts1) {
        this.uts1 = uts1;
    }
    
}

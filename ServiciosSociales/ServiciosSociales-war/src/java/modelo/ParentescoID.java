/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author FranciscoJosé
 */
@Embeddable
public class ParentescoID implements Serializable {
    @Column(name = "CIUDADANO1")
    private String ciudadanoDni1;
    @Column(name = "CIUDADANO2")
    private String ciudadanoDni2;

    public ParentescoID() {
    }

    public ParentescoID(String ciudadanoDni1, String ciudadanoDni2) {
        this.ciudadanoDni1 = ciudadanoDni1;
        this.ciudadanoDni2 = ciudadanoDni2;
    }

    public String getCiudadanoDni1() {
        return ciudadanoDni1;
    }

    public void setCiudadanoDni1(String ciudadanoDni1) {
        this.ciudadanoDni1 = ciudadanoDni1;
    }

    public String getCiudadanoDni2() {
        return ciudadanoDni2;
    }

    public void setCiudadanoDni2(String ciudadanoDni2) {
        this.ciudadanoDni2 = ciudadanoDni2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadanoDni1 != null ? ciudadanoDni1.hashCode() : 0);
        hash += (ciudadanoDni2 != null ? ciudadanoDni2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentescoID)) {
            return false;
        }
        ParentescoID other = (ParentescoID) object;
        if ((this.ciudadanoDni1 == null && other.ciudadanoDni1 != null) || (this.ciudadanoDni1 != null && !this.ciudadanoDni1.equals(other.ciudadanoDni1))) {
            return false;
        }
        if ((this.ciudadanoDni2 == null && other.ciudadanoDni2 != null) || (this.ciudadanoDni2 != null && !this.ciudadanoDni2.equals(other.ciudadanoDni2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebajpa.ParentescoPK[ ciudadanoDni=" + ciudadanoDni1 + ", ciudadanoDni1=" + ciudadanoDni2 + " ]";
    }
    
}

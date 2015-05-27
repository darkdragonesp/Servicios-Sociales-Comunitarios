/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.UTS;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkDragon
 */
@Local
public interface UTSLocal {
    public List<UTS> getUTSs();
    public boolean insertar(UTS uts);
    public boolean eliminar(UTS uts);

    
}


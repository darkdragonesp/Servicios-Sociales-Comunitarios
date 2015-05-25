package beans;

import entidades.Actividad;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JuanJo
 */

@FacesConverter("actividadconverter")
public class ActividadConverter implements Converter{
    
    public ActividadConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                //System.out.println("holaaaaa "+value);
                //System.out.println("killo "+(ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion"));
                ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
                //System.out.println("killoss "+(ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion"));
                //System.out.println(sesion.getUsuario().getActividades());
                return sesion.getUsuario().getActividades().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                System.out.println("error");
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object != null) {
            ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
            int i = sesion.getUsuario().getActividades().indexOf((Actividad) object);
            return Integer.toString(i);
        }else {
            return null;
        }
    }  
    
}

package beans;

import entidades.UTS;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JuanJo-DarkDragon
 */
@FacesConverter("utsconverter")
public class UTSConverter implements Converter {

    public UTSConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
//                utsBean sesion = (utsBean) context.getExternalContext().getSessionMap().get("utsBean");
//                return sesion.listar().get(Integer.parseInt(value));
                ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
                return sesion.getUtss().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                System.out.println("error");
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
//            utsBean sesion = (utsBean) context.getExternalContext().getSessionMap().get("utsBean");
//            int i = sesion.listar().indexOf((UTS) object);
            ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
            int i = sesion.getUtss().indexOf((UTS) object);
            return Integer.toString(i);
        } else {
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Actividad;
import entidades.Expediente;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author frasc_000
 */
@FacesConverter("expedienteconverter")
public class ExpedienteConverter implements Converter {

    public ExpedienteConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
                return sesion.getExpedientes().get(Integer.parseInt(value));
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
            ControlAutorizacion sesion = (ControlAutorizacion) context.getExternalContext().getSessionMap().get("controlAutorizacion");
            int i = sesion.getExpedientes().indexOf((Expediente) object);
            return Integer.toString(i);
        } else {
            return null;
        }
    }

}

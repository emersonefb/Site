package br.com.efb.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.efb.model.Service.EstadoService;
import br.com.efb.model.entity.Estado;

@Named
public class GrupoConverter implements Converter {


	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		if (id == null) {
			System.out.println("id nulo");
			return null;
		} else {

				return null;
		}
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object estado) {

		try {
			Estado e = (Estado) estado;
			return String.valueOf(e.getId());
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

}

package br.com.efb.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.efb.model.Service.CidadeService;
import br.com.efb.model.entity.Cidade;

@Named
public class CidadeConverter implements Converter {

	@Inject
	CidadeService cidadeService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		
		System.out.println("estou aqui iiiiiii"+id);
		if (id==null) {
			System.out.println("id nulo");
			return null;
		}
		
		try {
			return cidadeService.buscarPorId(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object cidade) {

		
		Cidade c = (Cidade) cidade;
		if (c.getId()==0) {
			return null;
		}
		
		return String.valueOf(c.getId());
	}

}

package br.com.efb.controller.bean;

import java.util.List;
//isso é teste

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.efb.model.Service.CidadeService;
import br.com.efb.model.Service.ServiceException;
import br.com.efb.model.dao.DAOException;
import br.com.efb.model.entity.Cidade;
import br.com.efb.model.entity.Estado;
import br.com.efb.model.entity.Usuario;

@Controller
@ViewScoped
public class CidadeBean {
//emerson
	Cidade cidade = new Cidade();

	@Inject
	private CidadeService cidadeService;

	private List<Cidade> cidades;

	@PostConstruct
	public void init() {
//		cidades = cidadeService.buscarTodos();
	}

	public void salvar() {
		try {
			cidadeService.salvar(cidade);
			
			//linda os dados de usuario
			cidade = new Cidade();
			Estado estado = new Estado();
			
			//faz uma busca para atualizar a lista
			cidades = cidadeService.buscarTodos();
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Salvo Com Sucesso", null));

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao Salvar: " + e.getMessage(), null));
		}
	}

	public void excluir() {
		try {
			cidadeService.excluir(cidade);

			// limpa cidade
			cidade = new Cidade();

			// atualiza lista de cidades
			setCidades(cidades);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cidade Exclido Com Sucesso", null));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Erro ao excluir Cidade: " + e.getMessage(), null));
		}
	}

	public void busarCidades(ValueChangeEvent evento) {

		if (evento.getNewValue()!= evento.getOldValue()) {
			Estado estado =  (Estado) evento.getNewValue();
			
			cidades = cidadeService.buscarCidades(estado);
		}
		
		
		
	}

	public CidadeService getCidadeService() {
		return cidadeService;
	}

	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}

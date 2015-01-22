package br.com.efb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.efb.model.Service.EstadoService;
import br.com.efb.model.dao.DAOException;
import br.com.efb.model.entity.Estado;

@Controller
@ViewScoped
public class EstadoBean {

	Estado estado = new Estado();

	@Inject
	private EstadoService estadoService;

	private List<Estado> estados;

	@PostConstruct
	public void init() {
		setEstados(estadoService.buscarTodos());
	}

	public void salvar() {
		try {
			estadoService.salvar(estado);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void excluir() {
		try {
			estadoService.excluir(estado);

			// limpa estado
			estado = new Estado();

			// atualiza lista de estados
			setEstados(estados);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Estado Exclido Com Sucesso", null));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Erro ao excluir Estado: " + e.getMessage(), null));
		}
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

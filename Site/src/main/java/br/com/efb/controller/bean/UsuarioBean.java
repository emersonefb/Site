package br.com.efb.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.annotation.*;

import org.springframework.stereotype.Controller;

import br.com.efb.model.Service.ServiceException;
import br.com.efb.model.Service.UsuarioService;
import br.com.efb.model.dao.DAOException;
import br.com.efb.model.entity.Cidade;
import br.com.efb.model.entity.Usuario;

@Controller
@ViewScoped
public class UsuarioBean {

	/**
	 * esta usuario vincula e manter os dados da tela
	 */
	Usuario usuario = new Usuario();

	@Inject
	private UsuarioService usuarioService;

	private List<Usuario> usuarioList;

	@PostConstruct
	public void init() {
		usuario.setCidade(new Cidade());
		setUsuarioList(usuarioService.buscartodos());
	}

	public void salvar() {
		try {
			
			
			usuarioService.salvar(usuario);
			usuario = new Usuario();
			usuario.setCidade(new Cidade());

			// atualiza lista
			setUsuarioList(usuarioService.buscartodos());
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
			usuarioService.excluir(usuario);
			
			//Limpa Usuario
			usuario = new Usuario();
			
			// atualiza lista
			setUsuarioList(usuarioService.buscartodos());

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Excluido Com Sucesso", null));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao Excluir: " + e.getMessage(), null));
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}

package br.com.efb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.efb.model.dao.GrupoDao;
import br.com.efb.model.entity.Grupo;

@Controller
@ViewScoped
public class GrupoBean {
	@Inject
	GrupoDao grupoDao;

	Grupo grupo = new Grupo();
	Grupo grupo1 = new Grupo();
	private List<Grupo> grupos;
	private List<Grupo> grupos1;

	private List<String> periodoa;
	private List<String> periodob;
	private List<String> periodoc;

	private List<String> Funcionario;

	@PostConstruct
	public void init() {
		grupos = grupoDao.buscartodos();
		for (Grupo grupo : grupos) {
			System.out.println(grupo.getNome());
			
		}
	}

	private void listarperiodo() {

	}

	public void busargrupo(ValueChangeEvent evento) {
		if (evento.getNewValue() != evento.getOldValue()) {
			Grupo grupoa = (Grupo) evento.getNewValue();

			grupo = grupoa;
		}

	}

	/**
	 * @return the grupoDao
	 */
	public GrupoDao getGrupoDao() {
		return grupoDao;
	}

	/**
	 * @param grupoDao
	 *            the grupoDao to set
	 */
	public void setGrupoDao(GrupoDao grupoDao) {
		this.grupoDao = grupoDao;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the grupos
	 */
	public List<Grupo> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos
	 *            the grupos to set
	 */
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	/**
	 * @return the periodoa
	 */
	public List<String> getPeriodoa() {
		return periodoa;
	}

	/**
	 * @param periodoa
	 *            the periodoa to set
	 */
	public void setPeriodoa(List<String> periodoa) {
		this.periodoa = periodoa;
	}

	/**
	 * @return the periodob
	 */
	public List<String> getPeriodob() {
		return periodob;
	}

	/**
	 * @param periodob
	 *            the periodob to set
	 */
	public void setPeriodob(List<String> periodob) {
		this.periodob = periodob;
	}

	/**
	 * @return the periodoc
	 */
	public List<String> getPeriodoc() {
		return periodoc;
	}

	/**
	 * @param periodoc
	 *            the periodoc to set
	 */
	public void setPeriodoc(List<String> periodoc) {
		this.periodoc = periodoc;
	}

	/**
	 * @return the funcionario
	 */
	public List<String> getFuncionario() {
		return Funcionario;
	}

	/**
	 * @param funcionario
	 *            the funcionario to set
	 */
	public void setFuncionario(List<String> funcionario) {
		Funcionario = funcionario;
	}

}

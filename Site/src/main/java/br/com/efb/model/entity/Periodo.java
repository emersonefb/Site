package br.com.efb.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Periodo {
	
	@Id
	@SequenceGenerator(name="seq_per", initialValue=1)
	@GeneratedValue(generator="seq_per", strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy="periodo",fetch=FetchType.LAZY)
	private List<Funcionario> funcionario;
	
	@JoinColumn
	@ManyToOne
	private Grupo grupo;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the funcionario
	 */
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	

}

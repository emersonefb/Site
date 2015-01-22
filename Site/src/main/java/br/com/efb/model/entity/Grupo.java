package br.com.efb.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Grupo {

	
	@Id
	@SequenceGenerator(name="seq_gru", initialValue=1)
	@GeneratedValue(generator="seq_gru", strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy="grupo",fetch=FetchType.LAZY)
	private List<Periodo> periodo;
	
	

	public Grupo() {
		this.id = 1;
		this.nome = "nome";
	}

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
	 * @return the periodo
	 */
	public List<Periodo> getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(List<Periodo> periodo) {
		this.periodo = periodo;
	}
	

}

package br.com.efb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.entity.Estado;

@Repository
public class EstadoDAO {

	@PersistenceContext
	EntityManager em;

	/**
	 * abre a conexao com o banco de dados
	 */
	public EstadoDAO() {

		//em = JPAUtil.abreconexao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Salva o Estado Passado no banco
	 * @param estado
	 * @throws DAOException 
	 */
	
	@Transactional
	public void salvar(Estado estado) throws DAOException {
		try {
			em.merge(estado);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Salvar", causa );
		}

	}

	/**
	 * exclui um Estado passado por parametro
	 * @param estado
	 * @throws DAOException 
	 */
	@Transactional
	public void excluir(Estado estado) throws DAOException {
		try {
			estado = buscarPorId(estado.getId());
			em.remove(estado);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Excluir", causa );
		}
	}

	/**
	 * Retorna uma lista de Estado
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Estado> buscartodos() {
		Query consulta = em.createQuery("select e from Estado E"); // JPQL
		return consulta.getResultList();
	}
	
	/**
	 * passe um id int e reterna um Estado
	 * @param id
	 * @return
	 */
	public Estado buscarPorId(int id) {
		return em.find(Estado.class, id);
	}

}

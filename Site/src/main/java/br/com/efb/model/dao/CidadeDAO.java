package br.com.efb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.entity.Cidade;
import br.com.efb.model.entity.Estado;

@Repository
public class CidadeDAO {

	@PersistenceContext
	EntityManager em;

	/**
	 * abre a conexao com o banco de dados
	 */
	public CidadeDAO() {

		//em = JPAUtil.abreconexao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Salva o Cidade Passado no banco
	 * @param cidade
	 * @throws DAOException 
	 */
	
	@Transactional
	public void salvar(Cidade cidade) throws DAOException {
		try {
			em.merge(cidade);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Salvar", causa );
		}

	}

	/**
	 * exclui um Cidade passado por parametro
	 * @param cidade
	 * @throws DAOException 
	 */
	@Transactional
	public void excluir(Cidade cidade) throws DAOException {
		try {
			cidade = buscarPorId(cidade.getId());
			em.remove(cidade);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Excluir", causa );
		}
	}

	/**
	 * Retorna uma lista de Cidade
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Cidade> buscartodos() {
		Query consulta = em.createQuery("select c from Cidade C"); // JPQL
		return consulta.getResultList();
	}
	
	/**
	 * passe um id int e reterna um Cidade
	 * @param id
	 * @return
	 */
	public Cidade buscarPorId(int id) {
		return em.find(Cidade.class, id);
	}

	public List<Cidade> buscarCidades(Estado estado) {
		Query consulta = em.createQuery("select c from Cidade c where c.estado=:est"); // JPQL
		consulta.setParameter("est", estado);
		return consulta.getResultList();
	}

}

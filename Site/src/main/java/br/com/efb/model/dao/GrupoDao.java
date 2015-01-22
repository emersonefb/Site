package br.com.efb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.entity.Grupo;
import br.com.efb.model.entity.Estado;

@Repository
public class GrupoDao {

	@PersistenceContext
	EntityManager em;

	/**
	 * abre a conexao com o banco de dados
	 */
	public GrupoDao() {

		//em = JPAUtil.abreconexao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Salva o Grupo Passado no banco
	 * @param cidade
	 * @throws DAOException 
	 */
	
	@Transactional
	public void salvar(Grupo cidade) throws DAOException {
		try {
			em.merge(cidade);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Salvar", causa );
		}

	}

	/**
	 * exclui um Grupo passado por parametro
	 * @param cidade
	 * @throws DAOException 
	 */
	@Transactional
	public void excluir(Grupo cidade) throws DAOException {
		try {
			cidade = buscarPorId(cidade.getId());
			em.remove(cidade);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Excluir", causa );
		}
	}

	/**
	 * Retorna uma lista de Grupo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Grupo> buscartodos() {
		Query consulta = em.createQuery("select c from Grupo C"); // JPQL
		return consulta.getResultList();
	}
	
	/**
	 * passe um id int e reterna um Grupo
	 * @param id
	 * @return
	 */
	public Grupo buscarPorId(int id) {
		return em.find(Grupo.class, id);
	}

	public List<Grupo> buscarGrupos(Estado estado) {
		Query consulta = em.createQuery("select c from Grupo c where c.estado=:est"); // JPQL
		consulta.setParameter("est", estado);
		return consulta.getResultList();
	}

}

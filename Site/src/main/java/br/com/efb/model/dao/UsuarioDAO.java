package br.com.efb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	/**
	 * abre a conexao com o banco de dados
	 */
	public UsuarioDAO() {

		//em = JPAUtil.abreconexao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Salva o Usuario Passado no banco
	 * @param usuario
	 * @throws DAOException 
	 */
	
	@Transactional
	public void salvar(Usuario usuario) throws DAOException {
		try {
			em.merge(usuario);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Salvar", causa );
		}

	}

	/**
	 * exclui um Usuario passado por parametro
	 * @param usuario
	 * @throws DAOException 
	 */
	@Transactional
	public void excluir(Usuario usuario) throws DAOException {
		try {
			usuario = buscarPorId(usuario.getId());
			em.remove(usuario);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Não Foi Possivel Excluir", causa );
		}
	}

	/**
	 * Retorna uma lista de Usuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> buscartodos() {
		Query consulta = em.createQuery("select u from Usuario U"); // JPQL
		return consulta.getResultList();
	}
	
	/**
	 * passe um id int e reterna um Usuario
	 * @param id
	 * @return
	 */
	public Usuario buscarPorId(int id) {
		return em.find(Usuario.class, id);
	}

}

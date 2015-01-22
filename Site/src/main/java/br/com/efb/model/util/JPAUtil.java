package br.com.efb.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		em = entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 * Entrega uma instancia de EntityManager
	 * Retorna um Objeto EntityManager
	 * @return
	 */
	public static EntityManager abreconexao(){
		return em;
		
	}
	
}

package br.com.efb.model.Service;

import br.com.efb.model.dao.DAOException;

public class ServiceException extends Exception {

	/**
	 * retorna mensagem de erro
	 * @param mensagem
	 */
	public ServiceException(String mensagem) {
		super(mensagem);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String mensagem, DAOException causa) {
		// TODO Auto-generated constructor stub
		
		super(mensagem,causa);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

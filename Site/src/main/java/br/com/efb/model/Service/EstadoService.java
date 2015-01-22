package br.com.efb.model.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.EstadoDAO;
import br.com.efb.model.entity.Estado;

@Service
public class EstadoService {

	@Inject
	EstadoDAO estadoDAO;
	
	public void salvar(Estado estado) throws ServiceException {
		if (estado.getUf()==null||estado.getUf()=="") {
			throw new ServiceException("O estado esta Nulo");
			
		}
		try {
			estadoDAO.salvar(estado);
		} catch (DAOException causa) {
			// TODO: handle exception
			throw new ServiceException("Não foi possivel salvar Estado",causa);
		}
		
	}
	
	public Estado buscarPorId(int id) {
		return estadoDAO.buscarPorId(id);
	}

	public List<Estado> buscarTodos() {
		
		return estadoDAO.buscartodos();
	}

	public void excluir(Estado estado) throws DAOException {
		estadoDAO.excluir(estado);
		
	}
}

package br.com.efb.model.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.CidadeDAO;
import br.com.efb.model.entity.Cidade;
import br.com.efb.model.entity.Estado;

@Service
public class CidadeService {

	@Inject
	CidadeDAO cidadeDAO;
	
	public void salvar(Cidade cidade) throws ServiceException {
		if (cidade.getNome()==null||cidade.getNome()=="") {
			throw new ServiceException("O cidade esta Nulo");
			
		}
		try {
			cidadeDAO.salvar(cidade);
		} catch (DAOException causa) {
			// TODO: handle exception
			throw new ServiceException("Não foi possivel salvar Cidade",causa);
		}
		
	}
	
	public Cidade buscarPorId(int id) {
		return cidadeDAO.buscarPorId(id);
	}

	public List<Cidade> buscarTodos() {
		
		return cidadeDAO.buscartodos();
	}

	public void excluir(Cidade cidade) throws DAOException {
		cidadeDAO.excluir(cidade);
		
	}

	public List<Cidade> buscarCidades(Estado estado) {

	 return	cidadeDAO.buscarCidades(estado);
		
	}
}

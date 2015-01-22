package br.com.efb.model.Service;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Cause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.UsuarioDAO;
import br.com.efb.model.entity.Usuario;

@Service
public class UsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO; 
	
	public void salvar(Usuario usuario) throws ServiceException{
		
		if (usuario.getNome()==null || usuario.getNome()=="") {
			throw new  ServiceException("O usuario esta Nulo");
			
		}
		
		try {
			usuarioDAO.salvar(usuario);
		} catch (DAOException causa) {
			// TODO Auto-generated catch block
			causa.printStackTrace();
			throw new ServiceException("não foi possivel salvar", causa);
		}
	}
	
	public List<Usuario> buscartodos(){
		return usuarioDAO.buscartodos();
	}
	
	public void excluir(Usuario usuario) throws DAOException {

		usuarioDAO.excluir(usuario);
	}
}

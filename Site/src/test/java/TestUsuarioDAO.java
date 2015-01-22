import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.UsuarioDAO;
import br.com.efb.model.entity.Usuario;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestUsuarioDAO {
	
	//mostra que é gerenciado pelo spring
	@Inject
	UsuarioDAO usuarioDAO;

//	@Test
	public void salvar() throws DAOException {
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		usuario.setEmail("email");
		usuario.setSenha("senha");
		
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
//		Assert.assertNotNull(usuario.getId());
		
	}
	
//	@Test
	public void testBuscaTodos() {
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscartodos();
		
		assertTrue(lista.size()>0);
	}
	
//	@Test
	public void testBuscarPorId(){
		int id = 1;
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
	 	Usuario usuario = usuarioDAO.buscarPorId(id);
		System.out.println(usuario.getId());
		assertTrue(usuario.getId()==1);
	}
	
	@Test
	public void  excluir() throws DAOException {
		
		int id = 11;
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(id);
		usuarioDAO.excluir(usuario);
		
		assertTrue(usuario.getId()!=2);
		
		
	}

}

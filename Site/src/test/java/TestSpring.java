import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.UsuarioDAO;
import br.com.efb.model.entity.Usuario;


public class TestSpring {

	@Test
	public void testSpring() {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioDAO usuarioDAO = context.getBean(UsuarioDAO.class);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Emerson");
		usuario.setEmail("Emerson@gmail.com");
		usuario.setSenha("123");
		
		try {
			usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Assert.assertTrue(true);
	}

}

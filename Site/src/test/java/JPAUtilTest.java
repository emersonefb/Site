import javax.persistence.EntityManager;

import br.com.efb.model.entity.Usuario;
import br.com.efb.model.util.JPAUtil;


public class JPAUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//instancia gerenciador de Entity
		EntityManager em = JPAUtil.abreconexao();
		
		
		//instancia de usuario
		Usuario usuario = new Usuario();
//		usuario.setId(1);
		usuario.setNome("nome");
		usuario.setEmail("email");
		usuario.setSenha("senha");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
	}

}

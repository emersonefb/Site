import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.EstadoDAO;
import br.com.efb.model.entity.Estado;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestEstadoDAO {
	
	@Inject
	EstadoDAO estadoDAO;
	
//	@Test
	public void salvar() throws DAOException{
		Estado estado = new Estado();
		estado.setUf("MG");
		estadoDAO.salvar(estado);
	}
	
	@Test
	public void buscarTodos() {
		List<Estado> estados = estadoDAO.buscartodos();
		for (Estado estado : estados) {
			System.out.println(estado);
		}
	}

}

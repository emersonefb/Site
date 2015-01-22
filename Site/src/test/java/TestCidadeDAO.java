import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.model.dao.DAOException;
import br.com.efb.model.dao.CidadeDAO;
import br.com.efb.model.dao.EstadoDAO;
import br.com.efb.model.entity.Cidade;
import br.com.efb.model.entity.Estado;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCidadeDAO {
	
	@Inject
	CidadeDAO cidadeDAO;
	
	@Inject
	EstadoDAO estadoDAO;
	
	@Test
	public void salvar() throws DAOException{
		 Estado estado = estadoDAO.buscarPorId(2);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(estado);
		
		cidadeDAO.salvar(cidade);
	}

}

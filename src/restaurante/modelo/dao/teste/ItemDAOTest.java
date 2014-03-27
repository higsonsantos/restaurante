package restaurante.modelo.dao.teste;

import static org.junit.Assert.*;

import java.util.Calendar;
import javax.persistence.EntityManager;

//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Test;
import restaurante.modelo.bean.Item;
import restaurante.modelo.dao.JPAUtil;
import restaurante.modelo.dao.ItemDAO;


public class ItemDAOTest {

	@Test
	public void testCadastrar() {
		
		// Solicitacao de conexao ao SGBD
		EntityManager entityManager = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(entityManager);
		// Inicio da transacao
		entityManager.getTransaction().begin();
		// Criacao de um novo produto
		Item item = new Item();
		item.setNome("misto");
		item.setDescricao("pao de forma, presunto, queijo");
		item.setDataCadastro(Calendar.getInstance());
		item.setPreco(1.5);
		//Execucao do cadastro
		dao.cadastrar(item);
		//Fechamento da conexao
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//Realização do teste de cadastro
		Assert.assertNotNull(item.getId());
		
		//fail("Not yet implemented");
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}

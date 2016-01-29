package br.com.dextra.estagio2015.atv13;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;

import java.util.List;
import br.com.dextra.estagio2015.comum.JPAUtils;

public class VendaTest {

	/**
	 * O cliente (andrei@dextra-sw.com) mandou o seguinte email (aqui sem acentos porque eh codigo Java!):
	 * 
	 * "
	 * Pessoal,
	 * 
	 * O sistema esta bom, mas gostaria de fazer um pedido. Gostaria que os IDs das vendas fossem sequenciais. 
	 * Eles pulam alguns numeros em uma ordem que eu nao entendo direito.
	 * 
	 * Fico no aguardo,
	 * 
	 * Obrigado.
	 * 
	 * "
	 * 
	 * 
	 */
	
	/*
	 * Acrescimo de testes para os ID's
	 * 
	 * Nas classes ItemVenda.java e Venda.java houve a modificacao do SequenceName 
	 * e do name/generator de cada um, tornando-os independentes. 
	 *  
	 *  Deixamos de utilizar o banco de dados em arquivo (modificamos a url do persistence)
	 *  
	 */
	
	
	@Test
	public void testInserirVenda() {
		Venda venda = new Venda();
		venda.add(new ItemVenda(10.0));
		venda.add(new ItemVenda(20.0));
		venda.add(new ItemVenda(30.0));
		new VendaService().inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		new VendaService().inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		new VendaService().inserirVenda(venda);
		
		EntityManager em = JPAUtils.getEM();	
		
		assertEquals(3,  em.createQuery("FROM Venda", Venda.class).getResultList().size());
		assertEquals(1L, em.createQuery("FROM Venda", Venda.class).getResultList().stream().map(e -> e.getId()).toArray()[0]);
		assertEquals(2L, em.createQuery("FROM Venda", Venda.class).getResultList().stream().map(e -> e.getId()).toArray()[1]);
		assertEquals(3L, em.createQuery("FROM Venda", Venda.class).getResultList().stream().map(e -> e.getId()).toArray()[2]);
		assertEquals(2L, em.createQuery("FROM ItemVenda", ItemVenda.class).getResultList().stream().map(e -> e.getId()).toArray()[1]);
		
	}
}

package br.com.dextra.estagio2015.atv06;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dextra.estagio2015.atv10.CintoDoElvis;
import br.com.dextra.estagio2015.atv13.Venda;
import br.com.dextra.estagio2015.comum.Banco;
import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.JPA_DB_Utils;



public class Atividade6Test {

	@BeforeClass
	public static void setUp() throws Exception {
		JPA_DB_Utils.start();
	}

	// A modificação foi feita na classe Banco.java 
	// que consiste no acréscimo de uma anotation para o auto-incremento da variável id no bd
	
	@Test
	public void testeIdBanco() {
		List<Banco> bancos = new ArrayList<Banco>();

		bancos.add(criaBanco("A"));
		bancos.add(criaBanco("C"));
		//bancos.add(criaBanco("E"));
		//bancos.add(criaBanco("G"));
		
		//System.out.println("Bancos");
		
		//for (Banco b : bancos)
		//	System.out.println(b.getId());
		
			
		EntityManager em = JPAUtils.getEM();	
		
		//assertEquals(2,  em.createQuery("FROM Banco", Banco.class).getResultList().size());
		//assertEquals(1L,  em.createQuery("FROM Banco", Banco.class).getResultList().get(0).getId());
	}
	
	private Banco criaBanco(String nome) {
		return (Banco) JPAUtils.merge(new Banco(nome));
	}

}

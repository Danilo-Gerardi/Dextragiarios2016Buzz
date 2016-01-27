package br.com.dextra.estagio2015.atv07;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.estagio2015.comum.Produto;

public class Atividade7Test {
	
	//Refatorar e corrigir o metodo de verificaco de datas, sem mexer no teste
	@Test
	public void verificaData(){
		Atividade7 calendario = new Atividade7();
		Assert.assertTrue(calendario.verificaData(29l, 2l, 2016l));
		Assert.assertFalse(calendario.verificaData(29l, 2l, 2015l));
		Assert.assertTrue(calendario.verificaData(31l, 3l, 1l));
		Assert.assertFalse(calendario.verificaData(31l, 4l, 1l));
	}
	
	//Refatorar e corrigir o metodo de comparaco de strings, sem mexer no teste
	@Test
	public void verificaString(){
		Comparator comparator = new Comparator();
		Assert.assertTrue(comparator.comparaStrings("Teste", "tesTe","tEste"));
	}
	
	//Corrigir o metodo de recuperacao de produtos, sem mexer no teste
	@Test
	public void testeProdutos() {
		ProdutoServiceImpl service = new ProdutoServiceImpl();
		service.criaProdutos();
		List<Produto> produtos = service.getProdutos();
		Assert.assertEquals(produtos.get(0).getNome(), "Caixa de Som");
		Assert.assertEquals(produtos.get(0).getComprimento(), 1, 0.01);
		Assert.assertFalse(produtos.get(0).getPromocao());
	}
}

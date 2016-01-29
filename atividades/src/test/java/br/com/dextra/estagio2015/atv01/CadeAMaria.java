package br.com.dextra.estagio2015.atv01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
	Sem mexer no teste que não está passando, ache o erro e refatore o método "encontrarPessoaPorNome".
	Dica: Stream do Java 8
 */
public class CadeAMaria {

	@Test
	public void recuperaACoitadaDaMarias() {
		Map<Long, String> pessoas = new HashMap<Long, String>();

		pessoas.put(1l, "Maria");
		pessoas.put(2l, "Jose");
		pessoas.put(3l, "Antonio");
		pessoas.put(4l, "Tiago");

		List<String> pessoasEncontradas = new Pessoas().encontrarPessoaPorNome(pessoas, "Maria");

		Assert.assertEquals(1, pessoasEncontradas.size());
	}

	@Test
	public void recuperaACoitadaDaMariasComStream() {
		Map<Long, String> pessoas = new HashMap<Long, String>();

		pessoas.put(1l, "Maria");
		pessoas.put(2l, "Jose");
		pessoas.put(3l, "Antonio");
		pessoas.put(4l, "Tiago");

		List<String> pessoasEncontradas = new Pessoas().encontrarPessoaComStream(pessoas, "Maria");

		Assert.assertEquals(1, pessoasEncontradas.size());
	}
}

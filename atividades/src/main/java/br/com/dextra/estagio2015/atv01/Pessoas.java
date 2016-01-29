package br.com.dextra.estagio2015.atv01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// incompatibilidade no parametro do pessoas.get(i)
// estar indexando de 0

public class Pessoas {
	public List<String> encontrarPessoaPorNome(Map<Long, String> pessoas, String nome) {
		List<String> pessoasEncontradas = new ArrayList<String>();

		pessoas.forEach((k, v) -> {
			if (nome.equals(v))
				pessoasEncontradas.add(nome);
		});

		return pessoasEncontradas;
	}
}
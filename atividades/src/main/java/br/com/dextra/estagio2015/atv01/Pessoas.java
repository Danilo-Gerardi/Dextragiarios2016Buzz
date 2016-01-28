package br.com.dextra.estagio2015.atv01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

// Incompatibilidade no parametro do pessoas.get(i)
// Estar indexando de 0
// Melhor modo de iterar com java8 *-*

public class Pessoas {

	public List<String> encontrarPessoaPorNome(Map<Long, String> pessoas, String nome) {
		
		List<String> pessoasEncontradas = new ArrayList<String>();
		
		/*for (Long chave : pessoas.keySet()) {
			
			if (pessoas.get(chave).equals(nome))
				pessoasEncontradas.add(nome);

		}*/
		
		pessoas.forEach((k,v) -> {
			
			if(nome.equals(v))
				pessoasEncontradas.add(nome);
			
		});
		
		return pessoasEncontradas;
	}

	public List<String> encontrarPessoaComStream(Map<Long, String> pessoas, String nome) {
		return pessoas.entrySet().stream()
				.filter(e -> nome.equals(e.getValue()))
				//.map((e) -> e.getValue())
				.map(Map.Entry::getValue)
				.sorted(String::compareTo)
				.collect(toList());
	}
	
}
package br.com.dextra.estagio2015.atv03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jogo {
	List<Integer> baralho;

	public Jogo() {
		baralho = Arrays.asList(2, 3, 4, 5, 6, 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10,
				11, 2, 3, 4, 5, 6, 10, 10, 10, 11);
		Collections.shuffle(baralho);

	}

	public int entregaCarta() {
		Collections.shuffle(baralho);
		return (Integer) baralho.get(0);
	}

	public String verificaGanhador(int pontosJogador, int pontosComputador) {
		String resposta = "";

		// Encurtei os if's
		if ((pontosJogador == 21) || (pontosComputador > 21 && pontosJogador < 21)) {
			resposta = "Voce ganhou!";
		} else if ((pontosJogador < 21 && pontosComputador < 21) && (pontosJogador > pontosComputador)) {
			resposta = "Voce ganhou!";
		} else if ((pontosComputador > 21 && pontosJogador > 21) || (pontosComputador == pontosJogador)) {
			resposta = "Empate!";
		} else {
			resposta = "Computador ganhou!";
		}
		return resposta;
	}

}

package br.com.dextra.estagio2015.atv03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	private static List<Integer> baralho;

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
	
	public void comeca(Jogador jogador, Jogador computador) {

		boolean parou = false;
		boolean ganhou = false;
		Scanner entrada = new Scanner(System.in);
		String comando, resposta;

		while (!parou) {
			System.out.println("Pega carta ou para?");
			comando = entrada.nextLine();
			if (comando.equals("p")) {
				parou = true;
				break;
			}
			jogador.pegaCarta(entregaCarta());
			System.out.println(
					"Cartas: " + jogador.mostraMao() + "Sua pontuacao: " + Integer.toString(jogador.pegaPontuacao()));

			if (jogador.passouDe21()) {
				parou = true;
				break;
			} else if (jogador.verificaVitoria()) {
				ganhou = true;
				break;
			}
		}
		entrada.close();
		// vez do computador jogar
		if (!ganhou) {
			while (computador.pegaPontuacao() < 20) {
				computador.pegaCarta(entregaCarta());
			}
		}

		resposta = verificaGanhador(jogador.pegaPontuacao(), computador.pegaPontuacao());
		System.out.println("Pontuacao do Computador: " + computador.pegaPontuacao());
		System.out.println(resposta);
	}

}

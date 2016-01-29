package br.com.dextra.estagio2015.atv03;

import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();

		comeca(jogo, jogador, computador);

	}

	public static void comeca(Jogo jogo, Jogador jogador, Jogador computador) {

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
			jogador.pegaCarta(jogo.entregaCarta());
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
				computador.pegaCarta(jogo.entregaCarta());
			}
		}

		resposta = jogo.verificaGanhador(jogador.pegaPontuacao(), computador.pegaPontuacao());
		System.out.println("Pontuacao do Computador: " + computador.pegaPontuacao());
		System.out.println(resposta);
	}

}

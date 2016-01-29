package br.com.dextra.estagio2015.atv03;

public class BlackJack {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();

		jogo.comeca(jogador, computador);

	}
}

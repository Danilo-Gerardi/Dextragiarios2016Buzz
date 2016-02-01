package br.com.dextra.estagio2015.atv03;

public class BlackJack {

	public static void main(String[] args) {
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();
		Jogo jogo = new Jogo(jogador, computador);


		jogo.comeca();

	}
}

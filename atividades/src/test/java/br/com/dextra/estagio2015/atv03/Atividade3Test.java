package br.com.dextra.estagio2015.atv03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Atividade3Test {

	@Test
	public void testPegaCarta() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(8);
		assertEquals("10 8 ", jogador.mostraMao());
	}

	@Test
	public void testPegaPontuacao() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(7);
		assertEquals(17, jogador.pegaPontuacao());
	}

	@Test
	public void testPassouDe21() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(10);
		jogador.pegaCarta(7);
		assertEquals(true, jogador.passouDe21());
	}

	@Test
	public void testVerificaVitoria() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(11);
		assertEquals(true, jogador.verificaVitoria());
	}

	@Test
	public void testVerificaGanhador() throws Exception {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(7);
		Jogador computador = new Jogador();
		computador.pegaCarta(10);
		computador.pegaCarta(10);
		assertEquals("Computador ganhou!", jogo.verificaGanhador(jogador.pegaPontuacao(), computador.pegaPontuacao()));
	}

}

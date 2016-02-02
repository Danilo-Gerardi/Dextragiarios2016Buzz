package br.com.dextra.estagio2015.atv03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Atividade3Test {

	@Test
	public void testPegaCarta() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		jogador.pegaCarta(8);
		assertEquals("10 8 ", jogador.pegaMao());
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
	public void testVerificaGanhador() throws Exception {
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();
		jogador.pegaCarta(10);
		computador.pegaCarta(11);
		Jogo jogo=new Jogo(jogador,computador);
		assertEquals("Voce perdeu!", jogo.verificaGanhador());
		
	}

}

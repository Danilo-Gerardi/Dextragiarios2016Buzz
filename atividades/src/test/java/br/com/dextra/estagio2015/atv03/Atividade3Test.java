package br.com.dextra.estagio2015.atv03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Atividade3Test {

	@Test
	public void testJogador() throws Exception {
		Jogador jogador = new Jogador();
		jogador.pegaCarta(10);
		assertFalse(jogador.verificaVitoria());
		assertFalse(jogador.passouDe21());
		assertEquals(10,jogador.pegaPontuacao());
		assertEquals("10 ",jogador.mostraMao());
	}
	
	@Test
	public void testJogo() throws Exception {
		Jogo jogo=new Jogo();
		assertEquals("Computador ganhou!",jogo.verificaGanhador(20, 21));
		
	}

}

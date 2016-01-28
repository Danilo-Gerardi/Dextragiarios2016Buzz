package br.com.dextra.estagio2015.atv03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Jogo {
	List<Integer> baralho;
	
	public Jogo(){
		baralho = Arrays.asList(
				2, 3, 4, 5, 6, 10, 10, 10, 11, 
				2, 3, 4, 5, 6, 10, 10, 10, 11,
				2, 3, 4, 5, 6, 10, 10, 10, 11,
				2, 3, 4, 5, 6, 10, 10, 10, 11
			);
		Collections.shuffle(baralho);
	}
	
	public int entregaCarta(){
		Collections.shuffle(baralho);
		return (Integer) baralho.get(0);
	}
	
	public String verificaGanhador(int pontosJogador, int pontosComputador){
		String resposta="";
		
		if (pontosComputador == 21) {
			resposta="Computador ganhou!";
		} else if (pontosJogador == 21) {
			resposta="Voce ganhou!";
		} else if (pontosComputador > 21 && pontosJogador < 21) {
			resposta="Voce ganhou!";
		}else if (pontosComputador < 21 && pontosComputador > pontosJogador) {
			resposta="Computador ganhou!";
		} else if (pontosComputador == pontosJogador) {
			resposta="Empate";
		}
		return resposta;
	}
	

}

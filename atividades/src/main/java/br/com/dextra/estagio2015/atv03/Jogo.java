package br.com.dextra.estagio2015.atv03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jogo {
	private static List<Integer> baralho;
	//
	Jogador jogador = new Jogador();
	Jogador computador = new Jogador();

	//
	public Jogo(Jogador jogador, Jogador computador) {
		this.jogador = jogador;
		this.computador = computador;
		baralho = Arrays.asList(2, 3, 4, 5, 6, 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10,
				11, 2, 3, 4, 5, 6, 10, 10, 10, 11);
		Collections.shuffle(baralho);
	}

	public int entregaCarta() {
		Collections.shuffle(baralho);
		return (Integer) baralho.get(0);

	}

	public String verificaGanhador() {
		String resposta = "";
		if(this.jogador.passouDe21() || (this.computador.pegaPontuacao() <=21 && this.computador.pegaPontuacao()> this.jogador.pegaPontuacao())){
			resposta="Voce perdeu!";
		}else if(this.jogador.pegaPontuacao() == this.computador.pegaPontuacao()){
			resposta="Empate!";
		} else{
			resposta="Voce ganhou!";
		}
		
		return resposta;
	}

	public void comeca() {
		boolean perdeu=false;
		boolean parou = false;
		Mensageiro mensagem = new Mensageiro();
		String comando;
		// vez do jogador jogar
		while (!parou && !perdeu) {
			comando = mensagem.continuar();
			if (comando.equals("p")) {
				parou = true;
				break;
			}
			this.jogador.pegaCarta(entregaCarta());

			mensagem.mostraCartas(this.jogador.pegaMao());
			mensagem.mostraPontuacaoJogador(this.jogador.pegaPontuacao());
			if (this.jogador.passouDe21()) {
				perdeu = true;
			}
		}

		// vez do computador jogar
		while (this.computador.pegaPontuacao() < 18 && !perdeu) {
			this.computador.pegaCarta(entregaCarta());
		}
		mensagem.mostraPontuacaoComputador(this.computador.pegaPontuacao());
		mensagem.mostraResultado(verificaGanhador());
	}

}

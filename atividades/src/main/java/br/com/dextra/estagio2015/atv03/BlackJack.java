package br.com.dextra.estagio2015.atv03;



import java.util.Scanner;

/**
 * Esse blackjack está inteiro na função main.
 * Acreditamos que ele funciona. Mas nosso cliente andou reclamando.
 * Combinamos com ele e vamos adicionar testes JUnit para esse jogo e tentar deixar o código mais orientado a objetos.
 * Só que também combinamos que o jogo não pode ficar sem funcionar. Tem que funcionar durante a transformação de código estruturado para orientado a objetos.
 * 
 */
public class BlackJack {


	
	public static void main(String[] args) {
	
	
		
		boolean parou = false;
		boolean ganhou =false;
		Scanner entrada = new Scanner(System.in);
		String comando, resposta;
	
		Jogador jogador = new Jogador();
		Jogador computador = new Jogador();
		Jogo jogo = new Jogo();
	
		while(!parou){
			System.out.println("Pega carta ou para?");
			comando = entrada.nextLine();
			if (comando.equals("p")){
				parou = true;
				break;
			}
			jogador.pegaCarta(jogo.entregaCarta());
			System.out.println("Cartas: "+jogador.mostraMao()+" pontuacao: "+Integer.toString(jogador.pegaPontuacao()));
			
			if(jogador.passouDe21()){
				parou=true;
				break;
			}
			else if(jogador.verificaVitoria()){
				ganhou=true;
				break;
			}
		}
		entrada.close();
		
		if(!ganhou){
			while(computador.pegaPontuacao()<20){
				computador.pegaCarta(jogo.entregaCarta());
			}
		}
		
		resposta=jogo.verificaGanhador(jogador.pegaPontuacao(), computador.pegaPontuacao());
		System.out.println(resposta);
		
	}

}

package br.com.dextra.estagio2015.atv03;

import java.util.Scanner;

public class Mensageiro {
	Scanner entrada = new Scanner(System.in);
	public Mensageiro(){

	}
	
	public String continuar(){
		String resposta="";

		System.out.println("Pega carta ou para?");
		resposta = this.entrada.nextLine();
		
		return resposta;
	}
	
	public void mostraCartas(String mao){
		System.out.println("Cartas: " + mao);
	}
	
	public void mostraPontuacaoJogador(int pontuacaoJogador){
		System.out.println("Pontuacao: "+pontuacaoJogador);
	}
	
	public void mostraPontuacaoComputador(int pontuacaoComputador){
		System.out.println("Pontuacao do computador: "+pontuacaoComputador);
	}
	
	public void mostraResultado(String resultado){
		System.out.println(resultado);
		this.entrada.close();
	}
	
}

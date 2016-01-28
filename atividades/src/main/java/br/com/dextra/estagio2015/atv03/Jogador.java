package br.com.dextra.estagio2015.atv03;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Jogador {
	private List<Integer> maoDoJogador = new ArrayList<Integer>();
	
	public Jogador(){}
	
	public void pegaCarta(int carta){
		maoDoJogador.add(carta);
	}
	
	public int pegaPontuacao(){
		int pontuacao=0;
		for(Iterator<Integer> carta=maoDoJogador.iterator();carta.hasNext();){
			pontuacao += (Integer)carta.next(); 
		}
		
		
		return pontuacao;
	}
	
	public String mostraMao(){
		String mao = "";
		for (Iterator<Integer> it = maoDoJogador.iterator(); it.hasNext();) {
			Integer carta = (Integer) it.next();
			mao += carta + " ";
		}
		return mao;
		//System.out.println("Cartas: "+mao+" pontuacao: "+Integer.toString(pegaPontuacao()));
	}
	
	public boolean passouDe21(){
		return pegaPontuacao()>21;
	}
	
	public boolean verificaVitoria(){
		return pegaPontuacao()==21;
		
	}
}

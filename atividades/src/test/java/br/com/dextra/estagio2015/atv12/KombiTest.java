package br.com.dextra.estagio2015.atv12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * O Negocio e o seguinte...
 * 
 * Sou um Sutao, tenho muitas esposas, e por conseguencia muitas sogra...
 * 
 * Sabadao quero levar elas para a praia, mas so tenho uma Kombi!
 * 
 * Infelizmente nao tenho mais nenhum meio de transporte e tambem nao posso
 * deixar de levar nenhuma das minhas sogras...
 * 
 * Entao, sem alterar a classe kombi ou sogra, como posso colocar muito mais sogras nela?
 * 
 * Boa sorte!
 * 
 */

public class KombiTest {

	private Kombi kombi = new Kombi();
	Queue<Sogra> sogras = sogras();
	int numeroDeSogras = 0;

	@Test
	public void colocarSograNaKombi() {
		kombi.add(new umaPuxaAOutra(sogras.poll().getNome()));
		kombi.viaja();
	}
	
	public class umaPuxaAOutra extends Sogra {
		
		public umaPuxaAOutra(String nome) {
			super(nome);
		}

		/* Sogra eh o tipo de HashSet criado na classe Kombi. Para adicionar um objeto
		 * a um HashSet, o java chama um metodo no objeto chamado hashCode, que roda
		 * verificacoes antes de adicionar o objeto a Hash. Sobrescrevendo o metodo,
		 * podemos chamar um segundo adiciona antes de completar o primeiro, atrasando a
		 * contagem de itens no HashSet. 
		 * */
		
		@Override 
		public int hashCode() {
			if (numeroDeSogras < 10) {
				numeroDeSogras++;
				kombi.add(new umaPuxaAOutra(sogras.poll().getNome()));
			}
			return super.hashCode();
		}	
	}

	/* Pra lidar com o problema do nome das sogras, utilizei uma fila
	 * que remove a sogra e retorna o objeto, podendo entao adicionar
	 * sogras sem repeticao.
	 * */
	
	
	private Queue<Sogra> sogras() {
		Queue<Sogra> sogras = new LinkedList<Sogra>();
		sogras.add(new Sogra("Clendeuspauda"));
		sogras.add(new Sogra("Kyania"));
		sogras.add(new Sogra("Perianilda"));
		sogras.add(new Sogra("Priscila a rainha do deserto"));
		sogras.add(new Sogra("Giatila"));
		sogras.add(new Sogra("Ramindenia"));
		sogras.add(new Sogra("Quimiula"));
		sogras.add(new Sogra("Breniandra"));
		sogras.add(new Sogra("Nejauna"));
		sogras.add(new Sogra("Menanda"));
		sogras.add(new Sogra("Zonoastra"));
		sogras.add(new Sogra("Denoida"));
		sogras.add(new Sogra("Wilranda"));
		sogras.add(new Sogra("Joaniaka"));
		sogras.add(new Sogra("Vandaina"));
		return sogras;
	}
}

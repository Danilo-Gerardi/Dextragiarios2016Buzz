package br.com.dextra.estagio2015.atv14;

import java.lang.reflect.Field;
import java.io.FileNotFoundException;
import java.lang.reflect.*;

/**
 * @author jefferson.venancio
 * 
 *         Olá desenvolvedores!
 * 
 *         Seguinte, agora no Brasil o jogo "Black Jack" não é mais permitido
 *         (Algum dia já foi permitido?)
 * 
 *         Enfim, o cara que fez esse software Colocou um "Black Jack" logo que começa o programa
 *         gostaria que fosse alterado de "Black Jack" Para "21"
 * 
 *		   Há um porém, gostaria que nunca mais um "sysout" apresente "Black Jack". Mesmo que seja incluido futuramente. 
 * 
 *         Vocês podem me ajudar?
 * 
 *         Qualquer coisa me chama no talk, jefferson.venancio
 * 
 * 			reflection
 */
public class BlackJackEh21Agora {
	static {
		try {
			Field field = String.class.getDeclaredField("value");
			field.setAccessible(true);
			field.set("Bem vindo ao jogo de Black Jack!!", field.get("Bem vindo ao jogo de 21!!"));
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Out out = new Out("asd");
		System.setOut(out);
		System.out.println("Bem vindo ao jogo de Black Jack!!");
	}

}



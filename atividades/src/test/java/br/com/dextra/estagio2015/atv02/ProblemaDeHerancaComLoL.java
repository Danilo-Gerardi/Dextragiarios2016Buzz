package br.com.dextra.estagio2015.atv02;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/*
	Por que está dando NullPointer? Aparentemente está tudo certo, não está? rs
	
	R: O construtor do Warnick nao era executado. Isso acontece pois nao foi especificado na classe
	   filha quando o construtor da mesma deve ser executada. Com isso, o construtor da classe mae 
	   eh executada primeiro por padrao e nao executa o construtor da filha por nao ter especificacao.  
	   O problema foi resolvido utilizando o metodo super() e passando as atribuicoes para a mae. 
 */
public class ProblemaDeHerancaComLoL {

	@Test
	public void aMorteDeUmCampeao() {
		Warwick f = new Warwick();
		assertFalse(f.estaMorto());
	}
}


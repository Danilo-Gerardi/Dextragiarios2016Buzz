package br.com.dextra.estagio2015.atv02;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/*
	Por que está dando NullPointer? Aparentemente está tudo certo, não está? rs
 */
public class ProblemaDeHerancaComLoL {

	@Test
	public void aMorteDeUmCampeao() {
		Warwick f = new Warwick();
		assertFalse(f.estaMorto());
	}

}

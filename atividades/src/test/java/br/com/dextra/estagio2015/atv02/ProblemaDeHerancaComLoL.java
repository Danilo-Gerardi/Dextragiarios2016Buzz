package br.com.dextra.estagio2015.atv02;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/*
	Por que está dando NullPointer? Aparentemente está tudo certo, não está? rs
	
	R: O construtor do Warnick nao era executado. Ao inves disso, chamava o construtor do 
	   Campeao, que rodava o metodo prepararVida() sem setar valor algum. 
 */
public class ProblemaDeHerancaComLoL {

	@Test
	public void aMorteDeUmCampeao() {
		Warwick f = new Warwick();
		assertFalse(f.estaMorto());
	}
}


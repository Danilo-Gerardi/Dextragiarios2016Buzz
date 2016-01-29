package br.com.dextra.estagio2015.atv16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.dextra.estagio2015.atv16.ControleRemoto;
import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class TesteControleRemoto {

	@Test
	public void ligaDesliga() {
		Televisao tv = getTelevisao();

		assertFalse(tv.isLigada());

		new ControleRemoto(tv).clickon("liga");

		assertTrue(tv.isLigada());
	}

	@Test
	public void teclasNumericas() {
		Televisao tv = getTelevisao();
		assertEquals(0, tv.getCanal());

		ControleRemoto controle = new ControleRemoto(tv);

		// retiramos o 0
		assertCanal(tv, controle, "0");
		assertCanal(tv, controle, "1");
		assertCanal(tv, controle, "2");
		assertCanal(tv, controle, "3");
		assertCanal(tv, controle, "4");
		assertCanal(tv, controle, "5");
		assertCanal(tv, controle, "6");
		assertCanal(tv, controle, "7");
		assertCanal(tv, controle, "8");
		assertCanal(tv, controle, "9");
	}

	@Test
	public void teclasVolume() {
		Televisao tv = getTelevisao();
		ControleRemoto controle = new ControleRemoto(tv);

		assertEquals(5, tv.getVolume());
		assertVolume(tv, controle, "abaixar volume", 4);
		assertVolume(tv, controle, "aumentar volume", 5);
		assertVolume(tv, controle, "aumentar volume", 6);
	}

	@Test
	public void teclasMudancaCanais() {
		Televisao tv = getTelevisao();

		ControleRemoto controle = new ControleRemoto(tv);

		assertCanal(tv, controle, "7");
		assertCanal(tv, controle, "canal anterior", 6);
		assertCanal(tv, controle, "canal proximo", 7);
		assertCanal(tv, controle, "canal proximo", 8);
	}

	/*
	 * private static void click(ControleRemoto controle, String tecla) {
	 * controle.clickNumberChannel(tecla); }
	 */

	private static void assertVolume(Televisao tv, ControleRemoto controle, String tecla, int volumeEsperado) {
		controle.clickVolume(tecla);

		assertEquals(volumeEsperado, tv.getVolume());
		assertEquals("" + volumeEsperado, controle.getDisplay());
	}

	private void assertCanal(Televisao tv, ControleRemoto controle, String tecla, Integer expected) {
		assertEquals("", controle.getDisplay());

		controle.clickChangeChannel(tecla);

		assertEquals(expected.intValue(), tv.getCanal());
		assertEquals(expected.toString(), controle.getDisplay());

		controle.setDisplay("");
	}

	private static void assertCanal(Televisao tv, ControleRemoto controle, String tecla) {
		assertEquals("", controle.getDisplay());

		controle.clickNumberChannel(tecla);

		// incompativel type
		// assertEquals(tecla, tv.getCanal());

		assertEquals(tecla, "" + tv.getCanal());
		assertEquals(tecla, controle.getDisplay());

		controle.setDisplay("");
	}

	private Televisao getTelevisao() {
		return new Televisao();
	}

}

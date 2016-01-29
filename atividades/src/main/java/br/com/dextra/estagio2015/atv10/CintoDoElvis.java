package br.com.dextra.estagio2015.atv10;

import java.util.Calendar;

/**
 * Dizem que o rei do Rock'n'Roll, após a fama, engordava um número do cinto a
 * cada ano, e que este número coincidia com a sua idade. Ele nasceu em 1930.
 * Este programa serve para saber qual seria o tamanho do cinto dele se ele
 * estivesse vivo este ano.
 */
public class CintoDoElvis {
	/** excluí 2 variáveis e deixei apenas 1 método */
	private static final int DATA_NASCIMENTO = 1930;
	
	public static int getTamanhoDoCinto(){
		return DATA_NASCIMENTO - Calendar.getInstance().get(Calendar.YEAR);
	}
}

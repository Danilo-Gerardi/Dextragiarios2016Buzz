package br.com.dextra.estagio2015.atv15;

import java.math.BigDecimal;

/*
 * Estamos trabalhando com um sistema que possui diversas transacoes monetarias. 
 * 
 * R: O problema aqui era criar um teste pro metodo subtract do Pagamento :)
 */
public class Atividade15 {

	public static BigDecimal pagamento(BigDecimal valor, BigDecimal pagamento) {
		return pagamento.subtract(valor);
	}

}

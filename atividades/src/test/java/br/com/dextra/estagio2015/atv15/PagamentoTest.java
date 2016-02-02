package br.com.dextra.estagio2015.atv15;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PagamentoTest {

	@Test
	public void testValorInteiro() throws Exception {
		assertEquals(new BigDecimal("3"), Atividade15.pagamento(new BigDecimal("2"), new BigDecimal("5")));
	}

	@Test
	public void testValorReal() throws Exception {
		assertEquals(new BigDecimal("33.25"), Atividade15.pagamento(new BigDecimal("7.25"), new BigDecimal("40.50")));
	}

	@Test
	public void testValorExtenso() throws Exception {

		assertEquals(new BigDecimal("1883.40"),
				Atividade15.pagamento(new BigDecimal("60.60"), new BigDecimal("1944.00")));
		assertEquals(new BigDecimal("45000"), Atividade15.pagamento(new BigDecimal("55000"), new BigDecimal("100000")));

	}
	@Test
	public void testValorNegativo() throws Exception {
		assertEquals(new BigDecimal("-1883.40"),
				Atividade15.pagamento(new BigDecimal("1944.00"), new BigDecimal("60.60")));
		
	}
}

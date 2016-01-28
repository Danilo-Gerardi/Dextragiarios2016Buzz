package br.com.dextra.estagio2015.atv15;
import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;


public class PagamentoTest {

	@Test
	public void testSubtracao() {
		assertEquals(new BigDecimal(3), Atividade15.pagamento(new BigDecimal(2), new BigDecimal(5)));
	}
}

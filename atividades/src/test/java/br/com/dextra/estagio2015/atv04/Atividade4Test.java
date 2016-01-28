package br.com.dextra.estagio2015.atv04;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;

public class Atividade4Test {

	@Test 
	public void testListaContasDeCliente() {
		Cliente cliente = criaClienteTeste();
		Conta conta = criaContaTeste(1000);
		Conta conta2 = criaContaTeste(1000);
		CaixaEletronico.adicionaContaParaCliente(cliente, conta);
		CaixaEletronico.adicionaContaParaCliente(cliente, conta2);

		cliente = (Cliente) JPAUtils_Atv4.merge(cliente);
		List<Conta> contasDeCliente = CaixaEletronico.listaContasDeCliente(1L);
		assertEquals(2, contasDeCliente.size());
	}
	
	private Cliente criaClienteTeste() {
		return (Cliente) JPAUtils_Atv4.merge(new Cliente("Jeffinho PehFofo"));
	}
	
	private Conta criaContaTeste(double valor) {
		 return (Conta) JPAUtils_Atv4.merge(new Conta(valor));
	}
	
}

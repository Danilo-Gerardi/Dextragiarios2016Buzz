package br.com.dextra.estagio2015.atv04;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;

/**
 * refatorei os métodos e mudei @OneToMany(fetch = FetchType.EAGER, cascade =
 * CascadeType.ALL) na classe Cliente
 */

public class CaixaEletronico {

	public static List<Conta> listaContasDeCliente(Long idCliente) {
		Cliente cliente = JPAUtils_Atv4.find(Cliente.class, idCliente);
		return cliente.getContas();
	}

	public static void adicionaContaParaCliente(Cliente cliente, Conta conta) {
		cliente.addConta(conta);
		JPAUtils_Atv4.merge(cliente);
	}
}

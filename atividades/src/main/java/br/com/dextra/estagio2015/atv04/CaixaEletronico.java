package br.com.dextra.estagio2015.atv04;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;
import br.com.dextra.estagio2015.comum.JPAUtils;

/**
 * refatorei os métodos e mudei @OneToMany(fetch = FetchType.EAGER, cascade =
 * CascadeType.ALL) na classe Cliente
 */

public class CaixaEletronico {

	public static void startRequest() {
		JPAUtils_Atv4.open();
	}

	public static void finishRequest() {
		JPAUtils_Atv4.close();
	}

	public static List<Conta> listaContasDeCliente(Long idCliente) {
		Cliente cliente = JPAUtils_Atv4.<Cliente> find(Cliente.class, idCliente);
		return cliente.getContas();
	}

	public static void adicionaContaParaCliente(Cliente cliente, Conta conta) {
		cliente.addConta(conta);
		JPAUtils_Atv4.merge(cliente);
	}
}

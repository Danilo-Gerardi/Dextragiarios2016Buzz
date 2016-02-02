package br.com.dextra.estagio2015.atv07;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.estagio2015.atv04.JPAUtils_Atv4;
import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.Produto;

public class ProdutoServiceImpl {

	public static void startRequest() {
		JPAUtils_Atv7.open();
	}

	public static void finishRequest() {
		JPAUtils_Atv7.close();
	}
	
	public void criaProdutos() {
		Produto produto1 = new Produto("Caixa de Som", "Caixa de som potente", 320.9, 1.1, 1.20, 0.8, 1,
				TipoProduto.ELETRONICO, false);
		Produto produto2 = new Produto("Barbeador", "Barbeador economico", 110.9, 0.5, 0.3, 0.1, 0.1, TipoProduto.SAUDE,
				true);

		JPAUtils_Atv7.merge(produto1);
		JPAUtils_Atv7.merge(produto2);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos() {
		Query query = JPAUtils_Atv7.createQuery("SELECT p FROM Produto p where p.id IS NOT NULL", Produto.class);
		return (List<Produto>) query.getResultList();
	}

}

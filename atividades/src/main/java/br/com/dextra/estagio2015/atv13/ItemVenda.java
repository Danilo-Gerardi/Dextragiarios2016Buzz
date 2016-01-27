package br.com.dextra.estagio2015.atv13;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "sequence")
	private Long id;
	
	private Double valor;

	public ItemVenda() {
		
	}
	
	public ItemVenda(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public Double getValor() {
		return valor;
	}
}

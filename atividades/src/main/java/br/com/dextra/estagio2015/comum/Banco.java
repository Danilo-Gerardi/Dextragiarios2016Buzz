package br.com.dextra.estagio2015.comum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banco {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;

	private Banco() { }
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
}

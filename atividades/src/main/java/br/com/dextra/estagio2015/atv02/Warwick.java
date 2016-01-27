package br.com.dextra.estagio2015.atv02;

public class Warwick extends Campeao {

	public Warwick() {
		this.ataque = 593d;
		this.defesa = 452d;
		this.vida = 100d;
	}

	@Override
	public Boolean estaMorto() {
		return this.vida.equals(0d);
	}
}

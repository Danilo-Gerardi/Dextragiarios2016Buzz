package br.com.dextra.estagio2015.atv02;

public class Warwick extends Campeao {

	public Warwick() {
		super(593d, 452d, 100d);
	}

	@Override
	public Boolean estaMorto() {
		return this.vida.equals(0d);
	}
}
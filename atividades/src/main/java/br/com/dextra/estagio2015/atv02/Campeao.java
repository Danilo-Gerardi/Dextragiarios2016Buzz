package br.com.dextra.estagio2015.atv02;

public abstract class Campeao {

	protected Double ataque;
	protected Double defesa;
	protected Double vida;
	protected Double danos;

	public Campeao(double a, double d, double v) {
		this.ataque = a;
		this.defesa = d;
		this.vida   = v;	
		
		this.prepararVida();
	}

	void prepararVida() {
		if (estaMorto())
			this.danos = 100d;
		else
			this.danos = 0d;
	}

	abstract Boolean estaMorto();
}

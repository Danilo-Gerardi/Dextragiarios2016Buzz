package br.com.dextra.estagio2015.atv16;

import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class ControleRemoto {
	private Integer canal;

	private Televisao tv;
	private String display = "";

	public ControleRemoto(Televisao tv) {
		this.tv = tv;
	}

	public ControleRemoto setDisplay(String display) {
		this.display = display;
		return this;
	}

	public String getDisplay() {
		return display;
	}

	// retiramos a variavel displaybotao que era inutil rs
	public void clickon(String botao) {
		if (botao.equals("liga"))
			tv.setLigada(true);
	}

	public void clickVolume(String botao) {
		if (botao.contains("volume")) {
			if (botao.equals("abaixar volume")) {
				tv.abaixarVolume();
				this.setDisplay(String.valueOf(tv.getVolume()));
			} else if (botao.equals("aumentar volume")) {
				tv.aumentarVolume();
				this.setDisplay(String.valueOf(tv.getVolume()));
			}
		}
	}

	// Exclusão do botaoAsInt
	public void clickNumberChannel(String botao) {
		

		if (NumberUtils.isNumber(botao)) {

			canal = NumberUtils.asInt(botao);

			this.setDisplay(botao);

		} else canal = this.tv.getCanal();
		refreshDisplay(canal);
	}

	// Exclusão do canalAnterior e proximoCanal
	public void clickChangeChannel(String botao) {
	
		if (botao.contains("canal")) {
			if (botao.equals("canal anterior")) {
				canal = tv.getCanal() - 1;
				this.setDisplay(String.valueOf(tv.getCanal() - 1));
			} else if (botao.equals("canal proximo")) {
				canal = tv.getCanal() + 1;
				this.setDisplay(String.valueOf(tv.getCanal() + 1));
			} else 	canal = this.tv.getCanal();

		}
		this.refreshDisplay(canal);
	}

	// Extraimos
	private void refreshDisplay(Integer canal) {
		if (this.tv.getCanal() != canal) {
			this.tv.setCanal(canal);
		}
	}

}

package br.com.dextra.estagio2015.atv14;


import java.io.OutputStream;
import java.io.PrintStream;

public class Out extends PrintStream {
	
	public Out(OutputStream out) {
		super(out);
		}
	
	@Override
	public void println(String msg) {
		String aux = msg.toUpperCase();
		if (!aux.contains("BLACK JACK"))
			super.println(msg);
		else {
			String trecho = msg.substring(aux.indexOf("BLACK JACK"), aux.indexOf("BLACK JACK") + 11);
			super.println(msg.replace(trecho, "21"));
		}
	}

}

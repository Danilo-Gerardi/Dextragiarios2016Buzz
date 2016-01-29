package br.com.dextra.estagio2015.atv14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Out extends PrintStream {
	public Out(String file) throws FileNotFoundException {
		super(file);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void println(String msg) {
		String aux = msg.toUpperCase();
		if (!aux.contains("BLACK JACK"))
			System.out.println(msg);
		else {
			String trecho = msg.substring(aux.indexOf("BLACK JACK"), aux.indexOf("BLACK JACK") + 11);
			System.out.println(msg.replace(trecho, "21"));
		}
	}
}

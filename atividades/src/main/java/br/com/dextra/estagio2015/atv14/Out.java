package br.com.dextra.estagio2015.atv14;

public class Out {
	String msg;
	
	public Out() {
		msg = "";
	}
	
	public void println(String msg){
		String aux = msg.toUpperCase();
		if (!aux.contains("BLACK JACK"))
			System.out.println(msg);
		else {
			String trecho = msg.substring(aux.indexOf("BLACK JACK"), aux.indexOf("BLACK JACK")+ 11);
	    	System.out.println(msg.replace(trecho, "21"));
		}
			
	}
	
	
}

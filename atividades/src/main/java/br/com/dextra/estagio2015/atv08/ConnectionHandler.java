package br.com.dextra.estagio2015.atv08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionHandler {
	private Socket clientSocket;
	private ServerSocket serverSocket;

	ConnectionHandler(Socket c, ServerSocket ss) {
		this.clientSocket = c;
		this.serverSocket = ss;
	}

	public void start() {
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String inputLine, outputLine;

			ProtocoloDeMensagens pMsg = new ProtocoloDeMensagens();
			outputLine = pMsg.processaEntrada(null);
			out.println(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = pMsg.processaEntrada(inputLine);
				out.println(outputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

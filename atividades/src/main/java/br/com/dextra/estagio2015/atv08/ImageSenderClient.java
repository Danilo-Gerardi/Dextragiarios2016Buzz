package br.com.dextra.estagio2015.atv08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ImageSenderClient {
	public static void main(String[] args) throws IOException {
		String hostName = "localhost";
		int portNumber = 4444;

		try {
			Socket socket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;
			String chat = "";

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				chat += "Server: " + fromServer + "\n";
				if (fromServer.equals("Bye."))
					break;

				fromUser = stdIn.readLine();

				if (fromUser != null) {
					out.println(fromUser);
					chat += "Client: " + fromUser + "\n";
				}
			}
			chat += "\n";
			generateLog(chat, "./src/main/resources/Log.txt");
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}

	private static void generateLog(String content, String name) {
		try {
			PrintWriter pw;
			pw = new PrintWriter(new FileOutputStream(new File(name), true));
			pw.println(content);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

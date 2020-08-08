package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {

			System.out.println("Distribuindo taregas para " + socket);
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while (entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();

				switch (comando) {
				case "c1": {
					saidaCliente.println("Confirmação cliente c1");
					break;
				}
				case "c2": {
					saidaCliente.println("Confirmação cliente c2");
					break;
				}
				case "c3": {
					saidaCliente.println("Confirmação cliente c3");
					break;
				}
				default: 
					saidaCliente.println("comando não foi encontrado");
				}
				
				System.out.println(comando);
			}

			saidaCliente.close();
			entradaCliente.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

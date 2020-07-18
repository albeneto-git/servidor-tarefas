package br.com.alura.servidor;

import java.net.Socket;

public class DistribuirTarefas implements Runnable {
	
	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		System.out.println("Distribuindo taregas para " + socket);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}

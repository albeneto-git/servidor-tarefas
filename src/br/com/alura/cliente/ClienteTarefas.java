package br.com.alura.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {

		Socket socktSocket = new Socket("localhost", 12345);
		
		System.out.println("---- conexão estabelecida----");

		PrintStream saida = new PrintStream(socktSocket.getOutputStream());
		
		saida.println("c1");
		
		
		
		Scanner teclado = new Scanner(System.in);
		
		teclado.nextLine();

		saida.close();
		teclado.close();
		socktSocket.close();
		
	}

}

package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
	private ServerSocket servidor;
	private ExecutorService threadPool;
	private AtomicBoolean estaRodando;

	public ServidorTarefas() throws IOException {
		System.out.println("---iniciando servidor -----");
		this.servidor = new ServerSocket(12345);
		ThreadFactory defaultFactory = Executors.defaultThreadFactory();
		this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads(defaultFactory));        //newCachedThreadPool();
		this.estaRodando = new AtomicBoolean(true);
	}

	public void rodar() throws IOException {
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(this.threadPool, socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando " + this.estaRodando);
			}
		}		
	}

	public void parar() throws IOException {
		this.estaRodando.set(false);
		servidor.close();
		threadPool.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.parar();
	}
	
}

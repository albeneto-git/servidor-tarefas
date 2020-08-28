package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSFutureBanco implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadosFutureWSFutureBanco(Future<String> futureWS, Future<String> futureBanco,	PrintStream saidaCliente) {
		this.futureWS = futureWS;
		this.futureBanco = futureBanco;
		this.saidaCliente = saidaCliente;
	}

	@Override
	public Void call() throws Exception {
		
		System.out.println("Aguardando resultado do future WS e Banco.");
		
		try {
			
			String numeroMagico = this.futureWS.get(5, TimeUnit.SECONDS);
			String numeroMagico2 = this.futureBanco.get(5, TimeUnit.SECONDS);
			
			this.saidaCliente.println("Resultado do comando c2, WS: " + numeroMagico + ", Banco: " + numeroMagico2);
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: Cancelando a execucao do comando c2.");
			this.saidaCliente.println("Timeout: Na execução do comando c2!");
			this.futureWS.cancel(true);
			this.futureBanco.cancel(true);
			
		}
		
		System.out.println("Finalizou JuntaResultadosFutureWSFutureBanco.");
		
		return null;
	}

}

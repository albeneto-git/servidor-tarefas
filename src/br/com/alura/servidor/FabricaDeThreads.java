package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

import br.com.alura.servidor.test.TratadorDeExcecao;

public class FabricaDeThreads implements ThreadFactory {

	 private ThreadFactory defaultFactory;

	    public FabricaDeThreads(ThreadFactory defaultFactory) {
	        this.defaultFactory = defaultFactory;
	    }

	    @Override
	    public Thread newThread(Runnable tarefa) {

	        //criando uma thread usando para fabrica padrão
	        Thread thread = defaultFactory.newThread(tarefa); 

	        //personalizando a thread
	        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
	        return thread;
	    }
}

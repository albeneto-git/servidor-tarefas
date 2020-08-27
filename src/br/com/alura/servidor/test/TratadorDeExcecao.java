package br.com.alura.servidor.test;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Deu exceção na " + t.getName() + ", " + e.getMessage());
	}
}

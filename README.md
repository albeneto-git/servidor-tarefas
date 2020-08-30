# servidor-tarefas
Aplicação para estudo de Threads
- Thread e Runnable
- ExecutorService - Pool de Threads
	- CachedThreadPool
	- FixedTreadPool
- thread.join()
- volatile e AtomicBoolean (resolve o problema do cache das threads)
- UncaughtExceptionHandler (Tratamento de exceção centralizada)
- ThreadFactory
- Callable e Future (Possibilita o retorno da thread e a verificação futura se a thread terminou)
- BlockingQueue (Tratamento de fila thread safe)
	.put() (adiciona na fila respeitando o tamanho do número de threads)
	.take()(pega da fila respeitando o tamanho do número de threads)
	Ambos metodos travam a thread.

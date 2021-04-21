package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

    public static void main(String[] args) {

        //cria e nomeia cada executável
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 =  new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        // cria ExecutorService para gerenciar threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // inicia as três PrintTasks
        executorService.execute(task1); //inicia task1
        executorService.execute(task2);  // inicia task2
        executorService.execute(task3);  //inicia task3

        // fecha ExecutorService -- ele decide quando fechar threads
        executorService.shutdown();

        System.out.printf("Tasks started, mais end. %n%n");
    }
}// fim da classe TaskExecutor

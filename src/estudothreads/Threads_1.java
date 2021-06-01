package estudothreads;

public class Threads_1 {

    public static void main(String[] args) {
        // Thread atual
        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        // Nova thread
        MeuRunnable meuRunnable = new MeuRunnable();
        Thread t1 = new Thread(meuRunnable);
        //t1.run(); // apenas executando na mesma thread


        // Runnable como lambda
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        // Várias threads
        Thread t3 = new Thread(meuRunnable);

        t1.start(); // executando em uma nova thread
        t2.start();
        t3.start();
    }
}

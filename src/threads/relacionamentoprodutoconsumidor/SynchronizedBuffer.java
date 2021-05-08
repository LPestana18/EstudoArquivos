package threads.relacionamentoprodutoconsumidor;

import threads.buffer.Buffer;

//Sincronizando o acesso a dados mutáveis compartilhados usando
//métodos wait e notifyAll de Object.

public class SynchronizedBuffer implements Buffer {

    private int buffer = -1; // compartilhado pelas threads producer and consumer
    private boolean occupied = false;

    // coloca o valor no buffer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        // enquanto não houver posições vazias, coloca a thread em estado de espera
        while (occupied) {
            // envia informações da thread e do buffer para a saída, então espera
            System.out.println("Producer tries to write."); // apenas para demonstração
            displayState("Buffer full. Producer waits.");// apenas para demonstração
            wait();
        }


    }

    @Override
    public int blockingGet() throws InterruptedException {
        return 0;
    }

    private synchronized void displayState(String operation) {
        System.out.printf("\"%-40s%d\\t\\t%b%n%n", operation, buffer, occupied);
    }
}

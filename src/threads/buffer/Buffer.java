package threads.buffer;

// Interface Buffer especifica métodos chamados por Producer e Consumer
public interface Buffer {

    // coloca o valor int no Buffer
    public void blockingPut(int value) throws InterruptedException;

    // retorna o valor int a partir do Buffer
    public int blockingGet() throws InterruptedException;
}// fim da Interface Buffer


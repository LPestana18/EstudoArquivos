package threads.buffer;

import java.security.ProtectionDomain;
import java.security.SecureRandom;

public class Producer implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation; // referencia a objeto compartilhado

    // Construtor
    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // armezana os valores de 1 a 10 em sharedLocation
    @Override
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {

            try {
                Thread.sleep(generator.nextInt(3000));// sono aleátorio
                sharedLocation.blockingPut(count); // configura o  valor no buffer
                sum += count;  // incrementa soma de valores
                System.out.printf("\t%2d%n", sum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("Producer done  producing%nTerminating Producer%n");
    }
}// fim da classe

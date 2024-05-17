import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class main {
    private static final int TAMANHO_BUFFER = 10;
    static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(TAMANHO_BUFFER);
    static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tempo de produção (ms): ");
        int tempoProducao = scanner.nextInt();

        System.out.print("Digite o tempo de consumo (ms): ");
        int tempoConsumo = scanner.nextInt();

        Thread produtorThread = new Thread(new produtor(tempoProducao));
        Thread consumidorThread = new Thread(new consumidor(tempoConsumo));

        produtorThread.start();
        consumidorThread.start();

        // Interrompe as threads após 10 segundos
        try {
            Thread.sleep(10000); // 10 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        produtorThread.interrupt();
        consumidorThread.interrupt();

        try {
            produtorThread.join();
            consumidorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Programa encerrado.");
    }
}

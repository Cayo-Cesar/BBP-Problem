

public class consumidor implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                int item = main.buffer.take();
                System.out.println("Consumido: " + item);
                Thread.sleep((int) (Math.random() * 1000)); // Simula o tempo de consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

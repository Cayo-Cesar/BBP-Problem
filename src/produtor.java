

public class produtor implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100);
                main.buffer.put(item);
                System.out.println("Produzido: " + item);
                Thread.sleep((int) (Math.random() * 1000)); // Simula o tempo de produção
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


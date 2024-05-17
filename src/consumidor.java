public class consumidor implements Runnable {
    private final int tempoConsumo;

    public consumidor(int tempoConsumo) {
        this.tempoConsumo = tempoConsumo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (main.lock) {
                    while (main.buffer.isEmpty()) {
                        System.out.println("Buffer vazio, consumidor esperando...");
                        main.lock.wait();
                    }
                    int item = main.buffer.take();
                    System.out.println("Consumido: " + item);
                    main.lock.notifyAll();
                }

                Thread.sleep(tempoConsumo); // Tempo de consumo fornecido pelo usuário
            }
        } catch (InterruptedException e) {
            System.out.println("Consumidor Interrompido");
            Thread.currentThread().interrupt();
        }
    }
}

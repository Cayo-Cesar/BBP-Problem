public class produtor implements Runnable {
    private final int tempoProducao;

    public produtor(int tempoProducao) {
        this.tempoProducao = tempoProducao;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100);

                synchronized (main.lock) {
                    while (main.buffer.remainingCapacity() == 0) {
                        System.out.println("Buffer cheio, produtor esperando...");
                        main.lock.wait();
                    }
                    main.buffer.put(item);
                    System.out.println("Produzido: " + item);
                    main.lock.notifyAll();
                }

                Thread.sleep(tempoProducao); // Tempo de produção fornecido pelo usuário
            }
        } catch (InterruptedException e) {
            System.out.println("Produtor Interrompido");
            Thread.currentThread().interrupt();
        }
    }
}

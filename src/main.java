

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

    public class main {
        private static final int TAMANHO_BUFFER = 10;
        static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(TAMANHO_BUFFER);

        public static void main(String[] args) {
            Thread produtorThread = new Thread(new produtor());
            Thread consumidorThread = new Thread(new consumidor());

            produtorThread.start();
            consumidorThread.start();
        }
    }

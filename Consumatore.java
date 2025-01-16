public class Consumatore implements Runnable {
    private final Piatto piatto;

    public Consumatore(Piatto piatto) {
        this.piatto = piatto;
    }

    @Override
    public void run() {
        try {
            while (true) {
                piatto.mangiaBoccone();
                Thread.sleep(1000); // Simula il tempo necessario per consumare un boccone
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

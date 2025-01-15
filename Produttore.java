public class Produttore implements Runnable {
    private final Piatto piatto;

    public Produttore(Piatto piatto) {
        this.piatto = piatto;
    }

    @Override
    public void run() {
        int contatore = 1;
        try {
            while (true) {
                String boccone = "Boccone " + contatore++;
                piatto.aggiungiBoccone(boccone);
                Thread.sleep(500); // Simula il tempo necessario per preparare un nuovo boccone
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

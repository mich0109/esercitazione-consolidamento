import java.util.LinkedList;

public class Piatto {
    private final LinkedList<String> piatto = new LinkedList<>(); // Lista dei bocconi
    private final int MAX_BOCCONI = 10; // Capacità massima del piatto

    // Metodo per aggiungere un boccone
    public synchronized void aggiungiBoccone(String boccone) throws InterruptedException {
        while (piatto.size() == MAX_BOCCONI) {
            System.out.println("Il piatto è pieno, il produttore aspetta...");
            wait(); // Aspetta che ci sia spazio nel piatto
        }
        piatto.add(boccone);
        System.out.println("Produttore ha aggiunto: " + boccone + " (Bocconi nel piatto: " + piatto.size() + ")");
        notifyAll(); // Notifica al consumatore che è disponibile un boccone
    }

    // Metodo per rimuovere un boccone
    public synchronized String mangiaBoccone() throws InterruptedException {
        while (piatto.isEmpty()) {
            System.out.println("Il piatto è vuoto, il consumatore aspetta...");
            wait(); // Aspetta che ci sia almeno un boccone
        }
        String boccone = piatto.removeFirst();
        System.out.println("Consumatore ha mangiato: " + boccone + " (Bocconi rimasti: " + piatto.size() + ")");
        notifyAll(); // Notifica al produttore che c'è spazio nel piatto
        return boccone;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creazione della risorsa condivisa
        Piatto piatto = new Piatto();

        // Creazione dei thread per il produttore e il consumatore
        Thread produttore = new Thread(new Produttore(piatto));
        Thread consumatore = new Thread(new Consumatore(piatto));

        // Avvio dei thread
        produttore.start();
        consumatore.start();
    }
}


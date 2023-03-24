package catalogoBibliotecario;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import catalogoBibliotecario.Rivista.Periodicità;

public class Runnable {

    public static void main(String[] args) {
        
        Archivio archivio = new Archivio();
        
        // Aggiunta libri all'archivio
        Libro libro1 = new Libro(1001, "Il Signore degli Anelli", 1954, 1178, "J.R.R. Tolkien", "Fantasy");
        Libro libro2 = new Libro(1002, "La scelta", 1980, 900, "Laina Banks", "Fantasy");
        Libro libro3 = new Libro(1003, "Regina di scacchi", 1994, 198, "Carol Main", "Horror");
        
        
        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(libro3);
        
        
        // Aggiunta riviste all'archivio
        Rivista rivista1 = new Rivista(909, "Nikonista:Il bianco e nero della rivoluzione", 2018, 80, Periodicità.SEMESTRALE);
        Rivista rivista2 = new Rivista(910, "Witch:Mondo di Kandrakar", 2000, 90, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista(920, "Cioè n.4", 1990, 70,Periodicità.SETTIMANALE);
        
        
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);
        archivio.aggiungiElemento(rivista3);
        
        // Stampa dell'archivio completo
        List<ElementoCatalogo> catalogo = archivio.getListaElementi();
        System.out.println("Archivio completo:");
        for (ElementoCatalogo elemento : catalogo) {
            System.out.println(elemento.toString());
        }
        
     // Ricerca elemento tramite codice ISBN ed elimiazione
        Optional<ElementoCatalogo> elementoTrovato = archivio.cercaPerISBN(1001);
        System.out.println("Elemento trovato tramite codice ISBN:");
        if (elementoTrovato.isPresent()) {
            ElementoCatalogo elementoRimosso = elementoTrovato.get();
            System.out.println(elementoRimosso.toString());
            archivio.rimuoviPerISBN(elementoRimosso.getCodiceISBN());
            catalogo.remove(elementoRimosso);
            System.out.println("Elemento rimosso con successo: " + elementoRimosso + " ora la lista è: " + catalogo);
        } else {
            System.out.println("Nessun elemento trovato con il codice ISBN specificato.");
        }


        // Ricerca elementi tramite anno di pubblicazione
        List<ElementoCatalogo> elementiPerAnno = archivio.cercaPerAnnoPubblicazione(2000);
        System.out.println("Elementi trovati per anno di pubblicazione:");
        if (!elementiPerAnno.isEmpty()) {
            for (ElementoCatalogo elemento : elementiPerAnno) {
                System.out.println(elemento.toString());
            }
        } else {
            System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
        }
        
        // Ricerca di libri tramite nome dell'autore
        List<ElementoCatalogo> libriPerAutore = archivio.cercaPerAutore("Carol Main");
        System.out.println("Libri trovati per autore:");
        if (!libriPerAutore.isEmpty()) {
            for (ElementoCatalogo elemento : libriPerAutore) {
                System.out.println(elemento.toString());
            }
        } else {
            System.out.println("Nessun libro trovato per l'autore specificato.");
        }
        
        //controllo esistenza file e se ha i permessi di lettura e scrittura
        File file = new File("archivio.dat");
        try {
            if (file.createNewFile()) {
                System.out.println("File creato con successo.");
            } else {
                System.out.println("File già esistente.");
            }
        } catch (IOException e) {
            System.out.println("Errore durante la creazione del file: " + e.getMessage());
        }
        if (file.canRead() && file.canWrite()) {
            System.out.println("Il file ha i permessi di lettura e scrittura.");
        } else {
            System.out.println("Il file non ha i permessi di lettura e/o scrittura.");
        }

        // Salva l'archivio su disco
        try {
            archivio.salvaSuDisco("archivio.dat");
            System.out.println("Archivio salvato su disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dell'archivio su disco: " + e.getMessage());
        }
        
        // Carica l'archivio da disco
        try {
            archivio.caricaDaDisco("archivio.dat");
            System.out.println("Archivio caricato da disco.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento dell'archivio da disco: " + e.getMessage());
        }
        //controllo directory di lavoro corrente
        System.out.println(System.getProperty("user.dir"));
    }}

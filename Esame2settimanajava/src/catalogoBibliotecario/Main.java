package catalogoBibliotecario;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import catalogoBibliotecario.Rivista.Periodicità;

public class Main  {

    public static void main(String[] args) {
        
        Archivio archivio = new Archivio();
        
        // Aggiunta libri all'archivio
        Libro libro1 = new Libro(1001, "Il Signore degli Anelli", 1954, 1178, "J.R.R. Tolkien", "Fantasy");
        Libro libro2 = new Libro(1002, "La scelta", 1980, 900, "Laina Banks", "Fantasy");
        Libro libro3 = new Libro(1003, "Regina di scacchi", 1994, 198, "Carol Main", "Horror");
        
        
        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(libro3);
   
     // Aggiunta di un nuovo libro
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aggiungi un libro nuovo, cominciamo! Inserisci il codice ISBN:");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di fine linea lasciato dal metodo nextInt()

        System.out.println("Inserisci il titolo:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci l'anno di pubblicazione:");
        int annoPubblicazione = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci il numero di pagine:");
        int numPagine = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci il nome dell'autore:");
        String autore = scanner.nextLine();

        System.out.println("Inserisci il genere:");
        String genere = scanner.nextLine();

        Libro nuovoLibro = new Libro(isbn, titolo, annoPubblicazione, numPagine, autore, genere);
        archivio.aggiungiElemento(nuovoLibro);


        
        
        // Aggiunta riviste all'archivio
        Rivista rivista1 = new Rivista(909, "Nikonista:Il bianco e nero della rivoluzione", 2018, 80, Periodicità.SEMESTRALE);
        Rivista rivista2 = new Rivista(910, "Witch:Mondo di Kandrakar", 2000, 90, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista(920, "Cioè n.4", 1990, 70,Periodicità.SETTIMANALE);
        
        
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);
        archivio.aggiungiElemento(rivista3);
        


     // Aggiunta di una nuova rivista all'archivio
        Scanner sh = new Scanner(System.in);

     // Aggiunta di una nuova rivista all'archivio
     System.out.println("Aggiungi una rivista nuova, cominciamo!Inserisci il codice ISBN:");
     int codiceISSN = sh.nextInt();
     sh.nextLine(); // Consuma il carattere di fine linea

     System.out.println("Inserisci il titolo:");
     String titolo1 = sh.nextLine();

     System.out.println("Inserisci l'anno di pubblicazione:");
     int annoPubblicazione1 = sh.nextInt();
     sh.nextLine(); // Consuma il carattere di fine linea

     System.out.println("Inserisci il numero di pagine:");
     int numPagine1 = sh.nextInt();
     sh.nextLine(); // Consuma il carattere di fine linea

     System.out.println("Inserisci la periodicità (SETTIMANALE, MENSILE, BIMESTRALE, TRIMESTRALE, SEMESTRALE, ANNUALE):");
     Periodicità periodicità = Periodicità.valueOf(sh.nextLine().toUpperCase());

     Rivista nuovaRivista = new Rivista(codiceISSN, titolo1, annoPubblicazione1, numPagine1, periodicità);
     archivio.aggiungiElemento(nuovaRivista);


        
        // Stampa dell'archivio completo
        List<ElementoCatalogo> catalogo = archivio.getListaElementi();
        System.out.println("Archivio completo:");
        for (ElementoCatalogo elemento : catalogo) {
            System.out.println(elemento.toString());
        }
        
     // Ricerca elemento tramite codice ISBN ed eliminazione
        Scanner input = new Scanner(System.in);

     // Chiedi all'utente il codice ISBN dell'elemento da cercare
     System.out.print("Inserisci il codice ISBN dell'elemento da cercare: ");
     long codiceISBN = input.nextLong();

     Optional<ElementoCatalogo> elementoTrovato = archivio.cercaPerISBN(codiceISBN);

     if (elementoTrovato.isPresent()) {
         ElementoCatalogo elemento = elementoTrovato.get();
         System.out.println("Elemento trovato:");
         System.out.println(elemento.toString());

         // Chiedi all'utente se vuole eliminare l'elemento trovato
         System.out.print("Vuoi eliminare l'elemento trovato? (s/n): ");
         String conferma = input.next();
         if (conferma.equalsIgnoreCase("s")) {
             archivio.rimuoviElemento(codiceISBN);
             System.out.println("Elemento rimosso con successo.");
             System.out.println("Lista aggiornata:");
             System.out.println(archivio.getListaElementi().toString());
         } else {
             System.out.println("L'elemento non è stato eliminato.");
         }
     } else {
         System.out.println("Nessun elemento trovato con il codice ISBN specificato.");
     }





        // Ricerca elementi tramite anno di pubblicazione
     Scanner s = new Scanner(System.in);
     System.out.print("Cerca elemento tramite l'anno di pubblicazione: ");
     int anno = s.nextInt();

     List<ElementoCatalogo> elementiPerAnno = archivio.cercaPerAnnoPubblicazione(anno);
     System.out.println("Elementi trovati per anno di pubblicazione:");
     if (!elementiPerAnno.isEmpty()) {
         for (ElementoCatalogo elemento : elementiPerAnno) {
             System.out.println(elemento.toString());
         }
     } else {
         System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
     }

        
        // Ricerca di libri tramite nome dell'autore
     Scanner sc = new Scanner(System.in);
     System.out.print("Cerca elemento tramite nome dell'autore: ");
     String nomeAutore = sc.nextLine();

     List<ElementoCatalogo> libriPerAutore = archivio.cercaPerAutore(nomeAutore);
     System.out.println("Libri trovati per autore:");
     if (!libriPerAutore.isEmpty()) {
         for (ElementoCatalogo elemento : libriPerAutore) {
             System.out.println(elemento.toString());
         }
     } else {
         System.out.println("Nessun libro trovato per l'autore specificato.");
     }
     
     
     
     Scanner input1=new Scanner(System.in);
        
      // Salva l'archivio su disco
        System.out.println("Inserisci il nome del file su cui salvare l'archivio:");
        String nomeFile = input1.nextLine();

        try {
            archivio.salvaSuDisco(nomeFile);
            System.out.println("Archivio salvato su disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dell'archivio su disco: " + e.getMessage());
        }
      

     // Carica l'archivio da disco

        System.out.println("Inserisci il nome del file da cui caricare l'archivio:");
        String nomeFile1 = input1.nextLine();

        try {
            archivio.caricaDaDisco(nomeFile1);
            System.out.println("Archivio caricato da disco.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento dell'archivio da disco: " + e.getMessage());
        }

       
    }}

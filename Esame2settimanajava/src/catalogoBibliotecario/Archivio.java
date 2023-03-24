package catalogoBibliotecario;



import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio implements Serializable {
    private static final long serialVersionUID = 1L;
	private List<ElementoCatalogo> listaElementi;

    public Archivio() {
        this.listaElementi = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        this.listaElementi.add(elemento);
    }

    public void rimuoviElemento(long codiceISBN) {
        this.listaElementi.removeIf(e -> e.getCodiceISBN() == codiceISBN);
    }

    public Optional<ElementoCatalogo> cercaPerISBN(long codiceISBN) {
        return this.listaElementi.stream()
                .filter(e -> e.getCodiceISBN() == codiceISBN)
                .findFirst();
    }

    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        return this.listaElementi.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> cercaPerAutore(String autore) {
        return this.listaElementi.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(l -> l.getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvaSuDisco(String nomeFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.listaElementi);
        oos.close();
        fos.close();
    }

    @SuppressWarnings("unchecked")
	public void caricaDaDisco(String nomeFile) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.listaElementi = (List<ElementoCatalogo>) ois.readObject();
        ois.close();
        fis.close();
    }

	public List<ElementoCatalogo> getListaElementi() {
		
		return listaElementi;
	}

	public void rimuoviPerISBN(long codiceISBN) {
		listaElementi.stream()
                .filter(elemento -> elemento.getCodiceISBN() != codiceISBN)
                .collect(Collectors.toList());
		
	}

	
	}




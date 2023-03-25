package catalogoBibliotecario;

import java.io.Serializable;

public class Libro extends ElementoCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String autore;
	private String genere;

	public Libro(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	public String toString() {
		return "Libro{" + "codiceISBN=" + getCodiceISBN() + ", titolo='" + getTitolo() + '\'' + ", annoPubblicazione="
				+ getAnnoPubblicazione() + ", numeroPagine=" + getNumeroPagine() + ", autore='" + autore + '\''
				+ ", genere='" + genere + '\'' + '}';
	}
}


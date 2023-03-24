package catalogoBibliotecario;

import java.io.Serializable;

public class Rivista extends ElementoCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Periodicità periodicità;

    public enum Periodicità {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    public Rivista(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,Periodicità periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public String toString() {
        return "Rivista{" +
                "codiceISBN=" + getCodiceISBN() +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", periodicità:" + periodicità +
                '}';
    }
}


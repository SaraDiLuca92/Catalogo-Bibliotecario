package catalogoBibliotecario;

import java.io.Serializable;

public abstract class ElementoCatalogo implements Serializable {

	private static final long serialVersionUID = 1L;
	protected long codiceISBN;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public ElementoCatalogo(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    
    public long getCodiceISBN() {return codiceISBN;}	
	
	public String getTitolo() {return titolo;}
	
	public int getAnnoPubblicazione() {return annoPubblicazione;}
	
    public int getNumeroPagine() {return numeroPagine;}
}
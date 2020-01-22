package dbmanagers;

public class Commento {
    int articolo;
    String utente;
    String testo;

    public Commento() {
    }

    public Commento(int articolo, String utente, String testo) {
        this.articolo = articolo;
        this.utente = utente;
        this.testo = testo;
    }

    public int getArticolo() {
        return articolo;
    }

    public void setArticolo(int articolo) {
        this.articolo = articolo;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}

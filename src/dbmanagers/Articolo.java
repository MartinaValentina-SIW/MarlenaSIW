package dbmanagers;

public class Articolo {
    int id;
    String titolo;
    String sottotitolo;
    String testo;
    int numMiPiace;
    String autore;

    public Articolo(int id, String titolo, String sottotitolo, String testo, int numMiPiace, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.sottotitolo = sottotitolo;
        this.testo = testo;
        this.numMiPiace = numMiPiace;
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "id='" + id + '\'' +
                ", titolo='" + titolo + '\'' +
                ", sottotitolo='" + sottotitolo + '\'' +
                ", numeroMiPiace=" + numMiPiace +
                ", autore='" + autore + '\'' +
                '}';
    }

    public Articolo() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitolo() {return titolo;}

    public void setTitolo(String titolo) {this.titolo = titolo;}

    public String getSottotitolo() {return sottotitolo;}

    public void setSottotitolo(String sottotitolo) {this.sottotitolo = sottotitolo;}

    public String getTesto() {return testo;}

    public void setTesto(String testo) {this.testo = testo;}

    public int getNumMiPiace() {return numMiPiace;}

    public void setNumMiPiace(int numMiPiace) {this.numMiPiace = numMiPiace;}

    public String getAutore() {return autore;}

    public void setAutore(String autore) {this.autore = autore;}
}

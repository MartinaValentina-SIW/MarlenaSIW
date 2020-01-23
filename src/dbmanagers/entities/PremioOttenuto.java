package dbmanagers.entities;

public class PremioOttenuto {
    String utente;
    int premio;

    public PremioOttenuto(String utente, int premio) {
        this.utente = utente;
        this.premio = premio;
    }

    public PremioOttenuto() {
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }
}

package dbmanagers.entities;

public class Utente {
    String username;
    String email;
    String password;
    int totMiPiace = 0;
    String tipo;

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", totMiPiace=" + totMiPiace +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotMiPiace() {
        return totMiPiace;
    }

    public void setTotMiPiace(int totMiPiace) {
        this.totMiPiace = totMiPiace;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

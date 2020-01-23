package dbmanagers.entities;

public class Premio {
    int id;
    int costo;
    String nome;

    public Premio(int id, int costo, String nome) {
        this.id = id;
        this.costo = costo;
        this.nome = nome;
    }

    public Premio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

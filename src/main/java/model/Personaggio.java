package model;

import java.util.List;

public class Personaggio extends Entity{

    private String nome;

    private String razza;

    private String classe;

    private int livello;

    private int monete;

    private List<Item> items;

    public Personaggio(int id, String nome, String razza, String classe, int livello, int monete, List<Item> items) {
        super(id);
        this.nome = nome;
        this.razza = razza;
        this.classe = classe;
        this.livello = livello;
        this.monete = monete;
        this.items = items;
    }

    public Personaggio() {
    super();
    }

    public Personaggio(String nome, String razza, String classe, int livello, int monete) {
        this.nome = nome;
        this.razza = razza;
        this.classe = classe;
        this.livello = livello;
        this.monete = monete;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public int getMonete() {
        return monete;
    }

    public void setMonete(int monete) {
        this.monete = monete;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Personaggio{" +
                "nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                ", classe='" + classe + '\'' +
                ", livello=" + livello +
                ", monete=" + monete +
                ", items=" + items +
                '}';
    }
}

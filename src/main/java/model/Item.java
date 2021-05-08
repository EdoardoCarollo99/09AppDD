package model;

public class Item  extends Entity{

    private String nome;

    private String tipologia;

    private String descrizione;

    private int idreferenza;

    private int qty;


    public Item(int id, String nome, String tipologia, String descrizione, int qty) {
        super(id);
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.qty=qty;
    }

    public Item() {
        super();
    }

    public Item(String nome, String tipologia, String descrizione) {
        super();
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
    }

    public Item(String nome, String tipologia, String descrizione,int qty) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}

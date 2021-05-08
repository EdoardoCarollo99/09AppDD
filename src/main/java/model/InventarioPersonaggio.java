package model;

public class InventarioPersonaggio extends Entity{

    private int id_item;
    private int id_personaggio;
    private int qty;

    public InventarioPersonaggio(int id, int id_item, int id_personaggio, int qty) {
        super(id);
        this.id_item = id_item;
        this.id_personaggio = id_personaggio;
        this.qty = qty;
    }

    public InventarioPersonaggio(int id_item, int id_personaggio, int qty) {
        this.id_item = id_item;
        this.id_personaggio = id_personaggio;
        this.qty = qty;
    }

    public InventarioPersonaggio() {
        super();
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_personaggio() {
        return id_personaggio;
    }

    public void setId_personaggio(int id_personaggio) {
        this.id_personaggio = id_personaggio;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}

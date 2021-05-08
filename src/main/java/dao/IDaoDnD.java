package dao;

import model.InventarioPersonaggio;
import model.Item;
import model.Personaggio;

import java.util.List;

public interface IDaoDnD {
    public List<Personaggio> personaggi();

    public List<Item> items();

    public Personaggio personaggio(int id);

    public List<Item> items(int idPersonaggio);

    public Item item(int id);

    public void aggiungiPersonaggio(Personaggio p);

    public void aggiungiItem(Item i);

    public void assegnaItem(int idItem, int idPersonaggio, int qty);

    public void eliminaPersonaggio(int id);

    public void eliminaAssegnazione(int id_personaggio, int id_item);

    public void eliminaItem(int id);

    public void modificaQuantitaItem(int idItem, int idPersonaggio, int qty);

    public void modificaPersonaggio(Personaggio personaggio);

    public void modificaItem(Item item);
}

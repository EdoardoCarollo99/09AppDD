package dao;

import model.InventarioPersonaggio;
import model.Item;
import model.Personaggio;
import util.BasicDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoDnD extends BasicDao implements IDaoDnD {
    public DaoDnD(String dbAddress, String user, String password) {
        super(dbAddress, user, password);
    }

    @Override
    public List<Personaggio> personaggi() {
        List<Personaggio> personaggi = new ArrayList<>();
        List <Map<String, String>> maps = getAll("SELECT * FROM personaggi order by nome");
        for (Map<String, String> key :
              maps ){
            Personaggio p = new Personaggio();
            p.fromMap(key);
            personaggi.add(p);
        }
        return personaggi;
    }

    @Override
    public List<Item> items() {
        List<Item> items = new ArrayList<>();
        List <Map<String, String>> maps = getAll("SELECT * FROM items order by nome");
        for (Map<String, String> key :
                maps ){
            Item p = new Item();
            p.fromMap(key);
            items.add(p);
        }
        return items;
    }

    @Override
    public Personaggio personaggio(int id) {
        Personaggio p = new Personaggio();
        p.fromMap(getOne("SELECT * FROM personaggi Where id = ?", id));

        p.setItems(items(id));
        return p;
        /*nome - razza- livello - monete + + List dei suoi items*/
    }

    @Override
    public List<Item> items(int idPersonaggio) {
        List<Item> items = new ArrayList<>();
        List<Map<String, String>> map = getAll("SELECT items.id, items.nome, items.tipologia, items.descrizione, inventari_personaggi.qty FROM personaggi INNER JOIN inventari_personaggi ON id_personaggio = personaggi.id INNER JOIN items ON id_item = items.id WHERE personaggi.id = ?;", idPersonaggio);        for (Map<String, String> key :
                map ){
            Item p = new Item();
            p.fromMap(key);
            items.add(p);
        }
        return items;
    }

    @Override
    public Item item(int id) {
        Item item = new Item();
        item.fromMap(getOne("SELECT * FROM items WHERE id = ?", id));
        return item;

    }

    @Override
    public void aggiungiPersonaggio(Personaggio p) {

        execute("INSERT INTO personaggi (nome, razza, classe, livello, monete) values (?,?,?,?,?)",
                p.getNome(),
                p.getRazza(),
                p.getClasse(),
                p.getLivello(),
                p.getMonete());

    }

    @Override
    public void aggiungiItem(Item i) {
        execute("INSERT INTO items (nome, tipologia, descrizione) values (?,?,?)",
                i.getNome(),
                i.getTipologia(),
                i.getDescrizione());
    }

    @Override
    public void assegnaItem(int idItem, int idPersonaggio, int qty) {
        execute("insert into inventari_personaggi (id_item, id_personaggio, qty) values (?, ?, ?)",
                idItem,idPersonaggio,qty);

    }

    @Override
    public void eliminaPersonaggio(int id) {
        execute("DELETE FROM inventari_personaggi WHERE id_personaggio=?", id);
        execute("DELETE FROM personaggi WHERE id = ?", id);
    }

    @Override
    public void eliminaAssegnazione(int id_personaggio, int id_item) {
        execute("DELETE FROM inventari_personaggi WHERE id_personaggio=? AND id_item = ? ", id_personaggio,id_item);
    }

    @Override
    public void eliminaItem(int id) {
        execute("DELETE FROM inventari_personaggi WHERE id_item=?", id);
        execute("DELETE FROM items WHERE id = ?", id);
    }

    @Override
    public void modificaQuantitaItem(int idItem, int idPersonaggio, int qty) {
        execute("UPDATE inventari_personaggi SET qty = ? WHERE id_item = ? AND id_personaggio = ?", qty,idItem,idPersonaggio);
    }

    @Override
    public void modificaPersonaggio(Personaggio personaggio) {

        execute("UPDATE personaggio SET nome = ?, razza = ?, classe = ?, livello = ?, monete = ? WHERE id = ?",
                personaggio.getNome(), personaggio.getRazza(), personaggio.getClasse(), personaggio.getLivello(), personaggio.getMonete(), personaggio.getId());

    }

    @Override
    public void modificaItem(Item item) {

    }
}

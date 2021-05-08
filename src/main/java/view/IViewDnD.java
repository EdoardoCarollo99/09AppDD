package view;

import model.Item;
import model.Personaggio;

import java.util.List;



public interface IViewDnD {
public String renderBody(String body);

public String renderHomePage();

    /**
     * Questo metodo crea una tabella con la lista dei personaggi
     * @param personaggi
     * @return String lista personaggi
     */
public String renderPersonaggi(List<Personaggio> personaggi);

public String renderItems(List<Item> items);

public String render(Personaggio personaggio);

public String renderItem(Item item);

public String renderFormPersonaggio();

public String renderFormPersonaggio(Personaggio personaggio);

public String renderFormItem();

public String renderFormItem(Item item);

public String associazioneItem(List<Personaggio> ps, List<Item> is);

}

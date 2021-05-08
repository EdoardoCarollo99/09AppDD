package view;

import java.util.List;
import java.util.Map;


import model.Item;
import model.Personaggio;
import util.IMappablePro;
import util.ViewTemplateHTML;

public class ViewDnDHTML extends ViewTemplateHTML implements IViewDnD {

	public ViewDnDHTML(String percorsoTemplate) {
		super(percorsoTemplate);
	}
	
	public String renderBody(String body) {
		return caricaTemplate("base").replace("[BODY]", body);
	}

	@Override
	public String renderHomePage() {

		return renderBody(caricaTemplate("home"));

	}

	private String renderRowIMappable(IMappablePro obj, String template) {
		String ris = caricaTemplate(template);

		Map<String, String> map = obj.toMap();

		for (String key : map.keySet()) {
			ris = ris.replace("[" + key.toUpperCase() + "]", map.get(key));
		}

		return ris;
	}


	@Override
	public String renderPersonaggi(List<Personaggio> personaggi) {
		String lista = "";
		for (Personaggio p:
			 personaggi) {

			lista += renderRowIMappable(p, "riga_personaggi");
		}


		return renderBody(caricaTemplate("lista_personaggi")).replace("[LISTA]", lista);
	}

	@Override
	public String renderItems(List<Item> items) {
		String lista = "";
		for (Item i:
				items) {

			lista += renderRowIMappable(i, "riga_items");
		}



		return renderBody(caricaTemplate("lista_items")).replace("[LISTA]", lista);
	}

	@Override
	public String render(Personaggio personaggio) {
		String ris = renderRowIMappable(personaggio,"dettaglio");

		String lista="";
		for (Item i : personaggio.getItems()) {

			lista += renderRowIMappable(i,"riga_dettaglio").replace("[&IDPERSONAGGIO]",personaggio.getId()+"").replace("[&IDITEM]",i.getId()+"");

		}
		if(lista.equalsIgnoreCase("")){
			return renderBody(ris).replace("[LISTA]", "Questo personaggio non ha items nello zaino");
		}else{
			return renderBody(ris).replace("[LISTA]", lista);
		}

	}

	@Override
	public String renderItem(Item item) {

		return renderBody(renderRowIMappable(item, "dettaglio_items"));
	}

	@Override
	public String renderFormPersonaggio() {
		return renderBody(caricaTemplate("aggiungi_personaggio"));
	}

	@Override
	public String renderFormItem() {
		return renderBody(caricaTemplate("aggiungi_item"));
	}

	@Override
	public String associazioneItem(List<Personaggio> ps, List<Item> is) {
		String optionPersonaggi = "";
		String optionItems = "";

				//cmd=associazione&id_personaggio=15&id_item=1&qty=13

		for (Personaggio p : ps) {
			optionPersonaggi += "<option value='"+p.getId()+"'>"+p.getNome()+"</option>";
		}
		for (Item i : is) {
			optionItems += "<option value='"+i.getId()+"'>"+i.getNome()+"</option>";
		}
		String ris = renderBody(caricaTemplate("associazione").replace("[OPTIONPERSONAGGI]", optionPersonaggi)
															    .replace("[OPTIONITEMS]", optionItems));
		return ris;
	}

	@Override
	public String renderFormPersonaggio(Personaggio personaggio) {
		String ris = renderBody(renderRowIMappable(personaggio,"modifica_personaggio"));
		System.out.println(ris);
		return ris;
	}


	@Override
	public String renderFormItem(Item item) {
		return null;
	}


}
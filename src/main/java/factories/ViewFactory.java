package factories;

import view.IViewDnD;
import view.ViewDnDHTML;

public interface ViewFactory {

	String PERCORSO_TEMPLATE = "C:\\Users\\Nuovo Utente\\Desktop\\Programmazione\\Programmazione_Intermedio\\09AppDD\\src\\main\\webapp\\WEB-INF\\templates";
	
	static IViewDnD make () {
		return new ViewDnDHTML(PERCORSO_TEMPLATE);
	}
}

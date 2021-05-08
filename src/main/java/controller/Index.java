package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.IDaoDnD;
import factories.DaoFactory;
import factories.ViewFactory;

import model.InventarioPersonaggio;
import model.Item;
import model.Personaggio;
import view.IViewDnD;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDaoDnD dao;
	private IViewDnD view;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        dao = DaoFactory.make();
        view = ViewFactory.make();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if (cmd == null) cmd = "home";
		
		String ris = "";
		
		switch (cmd) {

			case"home":
				ris=view.renderHomePage();
				break;
			case"listapersonaggi":
				ris= view.renderPersonaggi(dao.personaggi());
				break;
			case"listaitems":
					ris = view.renderItems(dao.items());
				break;
			case"dettagliopersonaggio":
				int id = Integer.parseInt(request.getParameter("id"));
				ris= view.render(dao.personaggio(id));
				break;
			case "dettaglioitem":
				id=Integer.parseInt(request.getParameter("id"));
				ris = view.renderItem(dao.item(id));
				break;
			case"gotoaggiungi":
				ris = view.renderFormPersonaggio();
				break;
			case"aggiungi":
				String nome = request.getParameter("nome");
				String razza = request.getParameter("razza");
				String classe = request.getParameter("classe");
				int livello = Integer.parseInt(request.getParameter("livello"));
				int monete = Integer.parseInt(request.getParameter("monete"));
				Personaggio add = new Personaggio(nome,razza,classe,livello,monete);
				dao.aggiungiPersonaggio(add);
				response.sendRedirect("Index?cmd=listapersonaggi");
				break;
			case"gotoaggiungi_item":
				ris = view.renderFormItem();
				break;
			case"aggiungi_item":
				nome = request.getParameter("nome");
				String tipologia = request.getParameter("tipologia");
				String descrizione = request.getParameter("descrizione");
				Item addItem = new Item(nome,tipologia,descrizione);
				dao.aggiungiItem(addItem);
				response.sendRedirect("Index?cmd=listaitems");
				break;
			case"gotoassociazione":
				ris = view.associazioneItem(dao.personaggi(),dao.items());
				break;
			case"associazione":
				//cmd=associazione&id_personaggio=15&id_item=1&qty=13
				int idPersonaggio = Integer.parseInt(request.getParameter("id_personaggio"));
				int idItem = Integer.parseInt(request.getParameter("id_item"));
				int qty = Integer.parseInt(request.getParameter("qty"));
				dao.assegnaItem(idItem,idPersonaggio,qty);
				response.sendRedirect("Index?cmd=dettagliopersonaggio&id="+idPersonaggio);
				break;
			case"eliminapersonaggio":
				id=Integer.parseInt(request.getParameter("id"));
				dao.eliminaPersonaggio(id);
				response.sendRedirect("Index?cmd=listapersonaggi");
				break;
			case "eliminaassegnazione":
				id=Integer.parseInt(request.getParameter("id"));
				idItem=Integer.parseInt(request.getParameter("id_item"));
				dao.eliminaAssegnazione(id,idItem);
				response.sendRedirect("Index?cmd=dettagliopersonaggio&id="+id);
				break;
			case"eliminaitem":
				id=Integer.parseInt(request.getParameter("id"));
				dao.eliminaItem(id);
				response.sendRedirect("Index?cmd=listaitems");
				break;
			case"modifica_qty":
				id=Integer.parseInt(request.getParameter("id"));
				idItem=Integer.parseInt(request.getParameter("id_item"));
				qty = Integer.parseInt(request.getParameter("quantita"));
				dao.modificaQuantitaItem(idItem,id,qty);
				response.sendRedirect("Index?cmd=dettagliopersonaggio&id="+id);
				break;

			case"gotomodificapersonaggio":
				id=Integer.parseInt(request.getParameter("id"));
				ris=view.renderFormPersonaggio(dao.personaggio(id));
				break;

			case "":
			default:
				ris= "comando errato";
				break;
		}
		response.getWriter().append(ris);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
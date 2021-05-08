package model;

import util.IMappablePro;

// Tutte i nostri oggetti contenuti nel DB sono entità
/**
 * Classe di partenza per tutti gli oggetti che necessitano di persistenza
 * nel DB
 * Banalmente conterrà l'id come proprietà in comune tra tutte le entità
 * @author trito
 */
public abstract class Entity implements IMappablePro{

	private int id;

	public Entity(int id) {
		super();
		this.id = id;
	}

	public Entity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}
}

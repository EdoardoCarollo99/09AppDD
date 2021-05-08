package model;

import util.IMappablePro;

// Tutte i nostri oggetti contenuti nel DB sono entit�
/**
 * Classe di partenza per tutti gli oggetti che necessitano di persistenza
 * nel DB
 * Banalmente conterr� l'id come propriet� in comune tra tutte le entit�
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

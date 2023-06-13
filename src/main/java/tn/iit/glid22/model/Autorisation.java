package tn.iit.glid22.model;

import java.time.LocalDate;

public class Autorisation {
	private int id;
	private int id_enseignant;
	private int nb_heure;
	private String description; // Nouvelle propriété description
	private LocalDate date;
	
	public Autorisation(int id, int id_enseignant, int nb_heure, String description, LocalDate date) {
		super();
		this.id = id;
		this.id_enseignant = id_enseignant;
		this.date = date;
		this.nb_heure = nb_heure;
		this.description = description;
	}

	public Autorisation(int id_enseignant, int nb_heure, String description, LocalDate date) {
		super();
		this.id_enseignant = id_enseignant;
		this.date = date;
		this.nb_heure = nb_heure;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	

	public int getNb_heure() {
		return nb_heure;
	}

	public void setNb_heure(int nb_heure) {
		this.nb_heure = nb_heure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Autorisation [id=" + id + ", id_enseignant=" + id_enseignant + ", nb_heure="
				+ nb_heure + ", description=" + description+ ", date=" + date +"]";
	}


}

package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class EntrepriseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3152690779535828408L;

	
	private int id;
	
	private String name;
	
	
	private String raisonSocial;

	private List<DepartementDTO> departements = new ArrayList<>();

	public EntrepriseDTO() {
		super();
	}

	public EntrepriseDTO(String name, String raisonSocial) {
		this.name = name;
		this.raisonSocial = raisonSocial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public List<DepartementDTO> getDepartements() {
		return departements;
	}

	public void setDepartements(List<DepartementDTO> departements) {
		this.departements = departements;
	}
	
	
	public void addDepartement(DepartementDTO departement){
		departement.setEntreprise(this);
		this.departements.add(departement);
	}




}

package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



public class DepartementDTO implements Serializable {

	private static final long serialVersionUID = -357738161698377833L;


	private int id;
	
	private String name;
	

	private List<Employe> employes;
	

	private List<Mission> missions;

	private EntrepriseDTO entreprise;

	public DepartementDTO() {
		super();
	}
	
	public DepartementDTO(String name) {
		this.name = name;
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

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public EntrepriseDTO getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(EntrepriseDTO entrepriseDTO) {
		this.entreprise = entrepriseDTO;
	}
	
	

}

package jpa;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Residence {
	
	// --- Déclaration des propriétées ---
	private Long id;
	private double taille;
	private int nbPieces;
	private Personne personne;
	private Collection<Chauffage> chauffages;
	private Collection<EquipementElec> equipementElecs;
	
	/**
	 * Constructeur 1.
	 */
	public Residence() {
		this.chauffages = new HashSet<Chauffage>();
		this.equipementElecs = new HashSet<EquipementElec>();
	}
	
	/**
	 * Constructeur 2.
	 * @param taille
	 * @param nbPieces
	 */
	public Residence(float taille, int nbPieces) {
		super();
		this.taille = taille;
		this.nbPieces = nbPieces;
		this.chauffages = new HashSet<Chauffage>();
		this.equipementElecs = new HashSet<EquipementElec>();
	}
	
	/**
	 * Fonction qui retourne l'Id.
	 * @return id. Long
	 */
	@Id
    @GeneratedValue
    @Column(name="id")
	public Long getId() {
		return this.id;
	}
	
	
	
	/**
	 * @return the equipementElecs
	 */
	@OneToMany(targetEntity = EquipementElec.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
	public Collection<EquipementElec> getEquipementElecs() {
		return equipementElecs;
	}

	/**
	 * @param equipementElecs the equipementElecs to set
	 */
	public void setEquipementElecs(Collection<EquipementElec> equipementElecs) {
		this.equipementElecs = equipementElecs;
	}

	/**
	 * Fonction qui retourne la personne qui possède la résidence.
	 * @return personne . Personne
	 */
	@ManyToOne()
	public Personne getPersonne() {
		return this.personne;
	}
	
	@OneToMany(targetEntity = Chauffage.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
	public Collection<Chauffage> getChauffages(){
		return this.chauffages;
	}
	
	public void setChauffages(Collection<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}
	
	public void addChauffage(Chauffage chauffage) {
		this.chauffages.add(chauffage);
	}
	
	public void addEquipementElec(EquipementElec equipementElec) {
		this.equipementElecs.add(equipementElec);
	}
	
	/**
	 * Procédure qui modifie la personne qui possède la résidence.
	 * @param personne . Personne
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	/**
	 * Procédure qui modifie l'Id.
	 * @param id . Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Fonction qui retourne la taille de la résidence
	 * @return the taille
	 */
	@Column(name="taille")
	public double getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**
	 * @return the nbPieces
	 */
	@Column(name="nbpiece")
	public int getNbPieces() {
		return nbPieces;
	}

	/**
	 * @param nbPieces the nbPieces to set
	 */
	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
}

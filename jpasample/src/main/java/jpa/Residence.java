package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Residence {
	
	private Long id;
	private float taille;
	private int nbPieces;
	private Personne personne;
	
	/**
	 * Constructeur 1.
	 */
	public Residence() {}
	
	/**
	 * Constructeur 2.
	 * @param taille
	 * @param nbPieces
	 */
	public Residence(float taille, int nbPieces) {
		super();
		this.taille = taille;
		this.nbPieces = nbPieces;
	}
	
	@Id
    @GeneratedValue
    @Column(name="id")
	public Long getId() {
		return this.id;
	}
	
	@ManyToOne()
	public Personne getPersonne() {
		return this.personne;
	}
	
	
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the taille
	 */
	@Column(name="taille")
	public float getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(float taille) {
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

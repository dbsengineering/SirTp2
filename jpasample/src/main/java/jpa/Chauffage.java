package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chauffage {
	
	// --- Déclaration des propriétées --
	private Long id;
	private Residence residence;
	
	/**
	 * Constructeur.
	 */
	public Chauffage() {
		
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name="id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne()
	public Residence getResidence() {
		return this.residence;
	}
	
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
}

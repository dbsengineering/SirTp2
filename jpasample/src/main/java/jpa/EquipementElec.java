package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipementElec {
	
	private Long id;
	private double consommation;
	private Residence residence;
	
	/**
	 * 
	 */
	public EquipementElec() {}

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

	/**
	 * @return the consommation
	 */
	public double getConsommation() {
		return consommation;
	}

	/**
	 * @param consommation the consommation to set
	 */
	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}

	/**
	 * @return the residence
	 */
	@ManyToOne()
	public Residence getResidence() {
		return residence;
	}

	/**
	 * @param residence the residence to set
	 */
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	
	
	
}

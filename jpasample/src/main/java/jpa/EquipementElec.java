package jpa;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class EquipementElec extends Intelligent{
	
	//private Long id;
	private double consommation;
	private Residence residence;
	
	/**
	 * 
	 */
	public EquipementElec() {}

	/**
	 * @return the id
	 */
	/*@Id
	@GeneratedValue
	@Column(name="id_equipement")
	public Long getId() {
		return id;
	}*/

	/**
	 * @param id the id to set
	 */
	/*public void setId(Long id) {
		this.id = id;
	}*/

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

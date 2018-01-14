package jpa;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

//@DiscriminatorValue("E")
//@DiscriminatorColumn(name="CHauffage",discriminatorType="STRING", length=5)

@Entity
public class Chauffage extends Intelligent {
	
	// --- Déclaration des propriétées --
	//private Long id;
	private Residence residence;
	
	/**
	 * Constructeur.
	 */
	public Chauffage() {
		
	}

	/**
	 * @return the id
	 */
	/*@Id
	@GeneratedValue
	@Column(name="id_chauffage")
	public Long getId() {
		return id;
	}*/

	/**
	 * @param id the id to set
	 */
	/*public void setId(Long id) {
		this.id = id;
	}*/
	
	@ManyToOne()
	public Residence getResidence() {
		return this.residence;
	}
	
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
}

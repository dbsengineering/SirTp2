package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Intelligent {
	
	// --- Déclaration des propriétées ---
	private Long id;
	
	public Intelligent() {}
	

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}

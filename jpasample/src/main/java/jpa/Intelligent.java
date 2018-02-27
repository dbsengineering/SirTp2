package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/**
 * Classe Intelligent
 * 
 * @author Jeremy Cavron
 * @version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Intelligent {

  // --- Déclaration des propriétées ---
  private Long id;

  /**
   * Constructeur.
   */
  public Intelligent() {
  }

  /**
   * Fonction qui retourne l'id de la classe.
   * 
   * @return id : id de la classe.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  public Long getId() {
    return this.id;
  }

  /**
   * Procédure qui modifie l'id de la classe.
   * 
   * @param id
   *          : id de la classe.
   */
  public void setId(Long id) {
    this.id = id;
  }

}

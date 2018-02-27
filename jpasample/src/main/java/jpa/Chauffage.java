package jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

//@DiscriminatorValue("E")
//@DiscriminatorColumn(name="CHauffage",discriminatorType="STRING", length=5)
/**
 * Classe Chauffage qui hérite de la classe Intelligent
 * 
 * @author Jeremy Cavron
 * @version 1.0
 */
@Entity
public class Chauffage extends Intelligent {

  // --- Déclaration des propriétées --
  private Residence residence;

  /**
   * Constructeur.
   */
  public Chauffage() {

  }

  /**
   * Fonction qui retourne la résidence.
   * 
   * @return Residence
   */
  @ManyToOne()
  public Residence getResidence() {
    return this.residence;
  }

  /**
   * Procédure qui modifie la résidence.
   * 
   * @param residence
   *          : Residence
   */
  public void setResidence(Residence residence) {
    this.residence = residence;
  }
}

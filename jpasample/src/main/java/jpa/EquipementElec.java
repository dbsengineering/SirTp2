package jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
/**
 * Classe EquipementElec qui hérite de Intelligent.
 * 
 * @author Jeremy Cavron
 * @version 1.0
 *
 */
@Entity
public class EquipementElec extends Intelligent {

  // --- Déclaration des propriétées ---
  private double consommation;
  private Residence residence;

  /**
   * Constructeur de la classe.
   */
  public EquipementElec() {
  }

  /**
   * Fonction qui retourne la consommation de l'équipement
   * 
   * @return consommation : La consommation de l'équipement.
   */
  public double getConsommation() {
    return this.consommation;
  }

  /**
   * Procédure qui modifie la consommation de l'équipement.
   * 
   * @param consommation
   *          : consommation de l'équipement.
   */
  public void setConsommation(double consommation) {
    this.consommation = consommation;
  }

  /**
   * Fonction qui retourne la résidence où se trouve l'équipement.
   * 
   * @return residence : Résidence où se trouve l'équipement.
   */
  @ManyToOne()
  public Residence getResidence() {
    return this.residence;
  }

  /**
   * Procédure qui permet de modifier la résidence où se trouve l'équipement.
   * 
   * @param residence
   *          : résidence où se trouve l'équipement.
   */
  public void setResidence(Residence residence) {
    this.residence = residence;
  }
}

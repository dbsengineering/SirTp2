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

/**
 * Classe Residence.
 * 
 * @author Jeremy Cavron
 * @version 1.0
 */
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
   * Constructeur 1. Défaut.
   */
  public Residence() {
    this.chauffages = new HashSet<Chauffage>();
    this.equipementElecs = new HashSet<EquipementElec>();
  }

  /**
   * Constructeur 2. Avec paramètrse.
   * 
   * @param taille : taille de la résidence.
   * @param nbPieces : nombre de pièces de la résidence.
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
   * 
   * @return id : id de la résidence.
   */
  @Id
  @GeneratedValue
  @Column(name = "id")
  public Long getId() {
    return this.id;
  }

  /**
   * Fonction qui retourne la collection d'équipements électriques de la
   * résidence.
   * 
   * @return equipementElecs : collection d'équipements électriques.
   */
  @OneToMany(targetEntity = EquipementElec.class, cascade = {
      CascadeType.ALL }, orphanRemoval = true)
  public Collection<EquipementElec> getEquipementElecs() {
    return this.equipementElecs;
  }

  /**
   * Procédure qui permet de modifier la collection d'équipements électrique de la
   * résidence.
   * 
   * @param equipementElecs
   *          : colelction d'équipements électrique.
   */
  public void setEquipementElecs(Collection<EquipementElec> equipementElecs) {
    this.equipementElecs = equipementElecs;
  }

  /**
   * Fonction qui retourne la personne qui possède la résidence.
   * 
   * @return personne : Personne qui possède la résidence.
   */
  @ManyToOne()
  public Personne getPersonne() {
    return this.personne;
  }

  /**
   * Fonction qui retourne la collection de chauffages de la résidence.
   * 
   * @return chauffages : collection de chauffages.
   */
  @OneToMany(targetEntity = Chauffage.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
  public Collection<Chauffage> getChauffages() {
    return this.chauffages;
  }

  /**
   * Procédure qui modifie la collection de chauffages de la résidence.
   * 
   * @param chauffages
   *          : collection de chauffages.
   */
  public void setChauffages(Collection<Chauffage> chauffages) {
    this.chauffages = chauffages;
  }

  /**
   * Procédure qui ajoute un chauffage à la collection de chauffages de la
   * résidence.
   * 
   * @param chauffage
   *          : Chauffage.
   */
  public void addChauffage(Chauffage chauffage) {
    this.chauffages.add(chauffage);
  }

  /**
   * Procédure qui ajoute un équipement électique à la collection d'équipement
   * électrique de la résidence.
   * 
   * @param equipementElec
   *          : Equipement élecrtrique.
   */
  public void addEquipementElec(EquipementElec equipementElec) {
    this.equipementElecs.add(equipementElec);
  }

  /**
   * Procédure qui modifie la personne qui possède la résidence.
   * 
   * @param personne
   *          : Personne.
   */
  public void setPersonne(Personne personne) {
    this.personne = personne;
  }

  /**
   * Procédure qui modifie l'Id.
   * 
   * @param id
   *          : id de la résidence.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Fonction qui retourne la taille de la résidence
   * 
   * @return taille : taille de la résidence.
   */
  @Column(name = "taille")
  public double getTaille() {
    return this.taille;
  }

  /**
   * Procédure qui permet de modifier la taille de la résidence.
   * @param taille :
   *          taille de la résidence.
   */
  public void setTaille(double taille) {
    this.taille = taille;
  }

  /**
   * Fonction qui retourne le nombre de pièces de la résidence.
   * 
   * @return nbPieces : nombre de pièces.
   */
  @Column(name = "nbpiece")
  public int getNbPieces() {
    return this.nbPieces;
  }

  /**
   * Procédure qui modifie le nombre de pièces de la résidence.
   * 
   * @param nbPieces
   *          : nombre de pièces de la résidence.
   */
  public void setNbPieces(int nbPieces) {
    this.nbPieces = nbPieces;
  }
}

package jpa;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Classe Personne.
 * 
 * @author Jeremy Cavron
 * @version 1.0
 */
@Entity
public class Personne {

  // --- Déclaration des propriétés ---
  private Long id;
  private String nom;
  private String prenom;
  private String mail;
  private Collection<Residence> residences;
  private Collection<Personne> amis;

  /**
   * Constructeur 1. Par défaut.
   */
  public Personne() {
    super();
    amis = new HashSet<Personne>();
    residences = new HashSet<Residence>();
  }

  /**
   * Constructeur 2. Avec paramètres
   * 
   * @param nom
   *          : nom de la personne.
   * @param prenom
   *          : prénom de la personne.
   * @param mail
   *          : mail de la personne.
   */
  public Personne(String nom, String prenom, String mail) {
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
    amis = new HashSet<Personne>();
    residences = new HashSet<Residence>();
  }

  /**
   * Fonction qui retourne l'id de la personne.
   * 
   * @return id : id de la personne.
   */
  @Id
  @GeneratedValue
  @Column(name = "id")
  public Long getId() {
    return this.id;
  }

  /**
   * Procédure qui modifie l'id de la personne.
   * 
   * @param id
   *          : id de la personne.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Fonction qqui retourne le nom de la personne.
   * 
   * @return nom : nom de la personne.
   */
  @Column(name = "nom")
  public String getNom() {
    return this.nom;
  }

  /**
   * Procédure qui modifie le nom de la personne.
   * 
   * @param nom
   *          : nom de la personne. Type String
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Fonction qui retourne le prénom de la personne.
   * 
   * @return prenom : prénom de la personne.
   */
  @Column(name = "prenom")
  public String getPrenom() {
    return this.prenom;
  }

  /**
   * Procédure qui modifie le prénom de la personne.
   * 
   * @param prenom
   *          : prénom de la personne.
   */
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Fonction qui retourne le mail de la personne.
   * 
   * @return mail : mail de la personne.
   */
  @Column(name = "mail")
  public String getMail() {
    return this.mail;
  }

  /**
   * Procédure qui modifie le mail de la perosnne.
   * 
   * @param mail
   *          : mail de la personne. Type String.
   */
  public void setMail(String mail) {
    this.mail = mail;
  }

  /**
   * Procédure qui ajoute un ami à la personne.
   * 
   * @param ami
   *          : Ami de la personne.
   */
  public void addAmi(Personne ami) {
    amis.add(ami);
  }

  /**
   * Procédure qui ajoute une résidence à la personne.
   * 
   * @param residence
   *          : Résidence de la personne. Type Residence.
   */
  public void addResidence(Residence residence) {
    this.residences.add(residence);
  }

  /**
   * Fonction qui retourne la collection d'amis de la personne.
   * 
   * @return amis : Collection d'amis de la personne.
   */
  @ManyToMany(targetEntity = Personne.class)
  public Collection<Personne> getAmis() {
    return this.amis;
  }

  /**
   * Procédure qui modifie la collection d'amis de la personne.
   * 
   * @param amis
   *          : Collection d'amis de la personne.
   */
  public void setAmis(Collection<Personne> amis) {
    this.amis = amis;
  }

  /**
   * Fonction qui retourne la liste des résidences de la personne.
   * 
   * @return residences : collection de résidences de la personne.
   */
  @OneToMany(targetEntity = Residence.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
  public Collection<Residence> getResidences() {
    return this.residences;
  }

  /**
   * Procédure qui modifie la collection de résidences de la personne.
   * 
   * @param residences
   *          : collection de résidences de la personne.
   */
  public void setResidences(Collection<Residence> residences) {
    this.residences = residences;
  }
}

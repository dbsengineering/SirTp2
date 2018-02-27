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

@Entity
public class Personne {

  private Long id;
  private String nom;
  private String prenom;
  private String mail;
  private Collection<Residence> residences;
  private Collection<Personne> amis;

  /**
   * Constructeur 1
   */
  public Personne() {
    super();
    amis = new HashSet<Personne>();
    residences = new HashSet<Residence>();
  }

  public Personne(String nom, String prenom, String mail) {
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
    amis = new HashSet<Personne>();
    residences = new HashSet<Residence>();
  }

  @Id
  @GeneratedValue
  @Column(name = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Column(name = "prenom")
  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Column(name = "mail")
  public String getMail() {
    return this.mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public void addAmi(Personne ami) {
    amis.add(ami);
  }

  public void addResidence(Residence residence) {
    this.residences.add(residence);
  }

  @ManyToMany(targetEntity = Personne.class)
  public Collection<Personne> getAmis() {
    return this.amis;
  }

  public void setAmis(Collection<Personne> amis) {
    this.amis = amis;
  }

  @OneToMany(targetEntity = Residence.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
  public Collection<Residence> getResidences() {
    return this.residences;
  }

  public void setResidences(Collection<Residence> residences) {
    this.residences = residences;
  }
}

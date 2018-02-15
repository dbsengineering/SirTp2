package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
	
	//--- Déclaration des propriétées ---
	private EntityManager manager;

	/**
	 * Constructeur de la classe.
	 * @param manager
	 */
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPersonnes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPersonnes();

		manager.close();
		long end = System.currentTimeMillis();
		long duree = end - start;
		
		System.out.println(".. ok");
		System.err.println("temps d'exec = " + duree + " ms");
	}

	/**
	 * 
	 */
	private void createPersonnes() {
		int numPersonne = manager.createQuery("Select a From Personne a", Personne.class).getResultList().size();
		
		if (numPersonne == 0) {
			
			// Création des résidences
			 Residence residence1 = new Residence(2000, 10);
			 Residence residence2 = new Residence(1000, 5);
			 Residence residence3 = new Residence(1500, 8);
			 Residence residence4 = new Residence(3000, 9);
			 Residence residence5 = new Residence(3000, 9);
			 Residence residence6 = new Residence(3000, 9);
			 Residence residence7 = new Residence(3000, 9);
			 Residence residence8 = new Residence(3000, 9);
			 Residence residence9 = new Residence(3000, 9);
			 Residence residence10 = new Residence(3000, 9);
			 
			//Création des chauffages
			 residence1.addChauffage(new Chauffage());
			 residence1.addChauffage(new Chauffage());
			 residence1.addChauffage(new Chauffage());
			 residence1.addChauffage(new Chauffage());
			 
			 residence2.addChauffage(new Chauffage());
			 residence2.addChauffage(new Chauffage());
			 residence2.addChauffage(new Chauffage());
			 residence2.addChauffage(new Chauffage());
			 residence2.addChauffage(new Chauffage());
			 
			 residence3.addChauffage(new Chauffage());
			 residence3.addChauffage(new Chauffage());
			 
			 residence4.addChauffage(new Chauffage());
			 residence4.addChauffage(new Chauffage());
			 residence4.addChauffage(new Chauffage());
			 
			 residence5.addChauffage(new Chauffage());
			 residence5.addChauffage(new Chauffage());
			 
			 //Ajout Equipement électronique
			 residence1.addEquipementElec(new EquipementElec());
			 residence1.addEquipementElec(new EquipementElec());
			 residence1.addEquipementElec(new EquipementElec());
			 residence1.addEquipementElec(new EquipementElec());
			 residence1.addEquipementElec(new EquipementElec());
			 residence1.addEquipementElec(new EquipementElec());
			 
			 
			 residence2.addEquipementElec(new EquipementElec());
			 residence2.addEquipementElec(new EquipementElec());
			 residence2.addEquipementElec(new EquipementElec());
			 
			 residence3.addEquipementElec(new EquipementElec());
			 residence3.addEquipementElec(new EquipementElec());
			 
			 residence10.addEquipementElec(new EquipementElec());
			 residence10.addEquipementElec(new EquipementElec());
			 residence10.addEquipementElec(new EquipementElec());

			Personne p1 = new Personne("Jaka", "Bada", "jaka.bada@breizh.bzh");
			Personne p2 = new Personne("Durand", "Henry", "durand.henry@breizh.bzh");
			Personne p3 = new Personne("Captain", "Nemo", "captain.nemo@breiah.bzh");
			Personne p4 = new Personne("Sarkozi", "Nicolas", "sarkozi.nicolas@orange.fr");
			Personne p5 = new Personne("Macron", "Emmanuel","macron.emmanuel@gmail.fr");
			Personne p6 = new Personne("Dupont", "Alain","dupont.alain@gmail.com");
			Personne p7 = new Personne("Hollande", "François", "hollande.francois@sfr.fr");

			//Ajout amis
			p1.addAmi(p2);
			p1.addAmi(p4);
			p2.addAmi(p7);
			p2.addAmi(p6);
			p4.addAmi(p5);
			
			
			//Ajout des résidences aux personnes
			p1.addResidence(residence1);
			p1.addResidence(residence2);
			p2.addResidence(residence3);
			p2.addResidence(residence9);
			p3.addResidence(residence4);
			p4.addResidence(residence5);
			p5.addResidence(residence6);
			p5.addResidence(residence10);
			p6.addResidence(residence7);
			p7.addResidence(residence8);
			

			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
			manager.persist(p4);
			manager.persist(p5);
			manager.persist(p6);
			manager.persist(p7);
		}
	}

	/**
	 * Procédure qui affiche les personnes
	 */
	private void listPersonnes() {
		List<Personne> resultList = manager.createQuery("Select a From Personne a", Personne.class).getResultList();
		System.out.println("num of personne:" + resultList.size());
		for (Personne next : resultList) {
			System.out.println("next personne: " + next);
		}
	}
}

package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaTest {
	private EntityManager manager;
    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory =   
              Persistence.createEntityManagerFactory("mysql");
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
        System.out.println(".. ok");
    }
    
    /**
     * 
     */
    private void createPersonnes() {
        int numOfEmployees = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
        if (numOfEmployees == 0) {
        	
        
        	
        	//Création des maisons
           /* Home home1 = new Home(2000, 10);
            Home home2 = new Home(1000, 5);
            Home home3 = new Home(1500, 8);
            Home home4 = new Home(3000, 9);*/
            
            //Ajout des chauffages, aux maisons
            /*home1.addHeater(new Heater());
            home1.addHeater(new Heater());
            home1.addHeater(new Heater());
            home1.addHeater(new Heater());
            
            home2.addHeater(new Heater());
            home2.addHeater(new Heater());
            home2.addHeater(new Heater());
            
            home3.addHeater(new Heater());
            home3.addHeater(new Heater());
            home3.addHeater(new Heater());
            
            home4.addHeater(new Heater());
            home4.addHeater(new Heater());
            home4.addHeater(new Heater());
            
            //Ajout des équipements électronique
            home1.addDevice(new ElectronicDevice(2000));
            home1.addDevice(new ElectronicDevice(1000));
            home1.addDevice(new ElectronicDevice(2000));
            home1.addDevice(new ElectronicDevice(1000));

            
            home2.addDevice(new ElectronicDevice(2000));
            home2.addDevice(new ElectronicDevice(2000));
            home2.addDevice(new ElectronicDevice(1000));
            
            home3.addDevice(new ElectronicDevice(1000));
            home3.addDevice(new ElectronicDevice(1000));
            home3.addDevice(new ElectronicDevice(2000));
            
            home4.addDevice(new ElectronicDevice(1000));*/
            
      
            
            //Ajout des maisons dans la base de données
           // manager.persist(home1);
            //manager.persist(home2);
            //manager.persist(home3);
            //manager.persist(home4);
            
            
            
            Person p1 = new Person("Jaka", "Bada");
            Person p2 = new Person("Durand", "Henry");
            Person p3 = new Person("Captain","Nemo");
            Person p4 = new Person("Dupont","Alain");
            Person p5 = new Person("Dupont","Alain");
            Person p6 = new Person("Dupont","Alain");
            Person p7 = new Person("Dupont","Alain");
            
            p1.addFriend(p2);
            p1.addFriend(p4);
            
            p2.addFriend(p1);
            p2.addFriend(p7);
            p2.addFriend(p6);
            
            /*p1.addHome(home1);
            p2.addHome(home2);
            p3.addHome(home3);
            p4.addHome(home4);*/
            
            
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
     * 
     */
    private void listPersonnes() {
        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
        System.out.println("num of person:" + resultList.size());
        for (Person next : resultList) {
            System.out.println("next person: " + next);
        }
    }
}

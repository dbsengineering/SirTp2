package jpa;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Person {

	private Long id;
    private String name;
    private String prenom;
    private String mail;
    //private Collection<Home> homes;
    private Collection<Person> friends;
    
    public Person() {
    	super();
    	friends = new ArrayList<Person>();
    	//homes = new ArrayList<Home>();
    }
    
    public Person(String name, String prenom) {
        this.name = name;
        this.prenom = prenom;
        friends = new ArrayList<Person>();
        //homes = new ArrayList<Home>();
    }
    
    @ManyToMany(targetEntity = Person.class)
    public Collection<Person> getFriends(){
    	return this.friends;
    }
    
    public void setFriends(Collection<Person> friends) {
    	this.friends = friends;
    }
    
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPrenom() {
    	return this.prenom;
    }
    
    public void setPrenom(String prenom) {
    	this.prenom = prenom;
    }
    
   /*@ManyToOne(targetEntity = Home.class)
    public Collection<Home> getHomes() {
        return this.homes;
    }*/
   
   public void addFriend(Person friend) {
	   friends.add(friend);
   }
    
   /* public void setHomes(Collection<Home> homes) {
        this.homes = homes;
    }*/
    
   /* public void addHome(Home home) {
    	this.homes.add(home);
    }*/
}

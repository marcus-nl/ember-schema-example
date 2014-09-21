package nl.marcus.ember.example.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Zoo {

	private final String id;
	private String name;
	private String city;
	private Person director;
	private List<Animal> animals;

	public Zoo(String id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.animals = new ArrayList<Animal>();
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Person getDirector() {
		return director;
	}
	
	public void setDirector(Person director) {
		this.director = director;
	}
	
	public List<Animal> getAnimals() {
		return animals;
	}
	
	public void addAnimal(Animal animal) {
		this.animals.add(animal);
	}
	
	@Override
	public String toString() {
		return "Zoo [name=" + name + ", city=" + city + ", director=" + director + ", animals=" + animals + "]";
	}
}
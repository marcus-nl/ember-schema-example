package nl.marcus.ember.example;

import nl.marcus.ember.example.model.Elephant;
import nl.marcus.ember.example.model.Lion;
import nl.marcus.ember.example.model.Person;
import nl.marcus.ember.example.model.Zoo;

import org.springframework.stereotype.Service;

@Service
public class ZooService {
	
	private final Zoo zoo;
	
	public ZooService() {
		zoo = new Zoo("Winterfell Zoo", "Winterfell");
		zoo.setDirector(new Person("A", "B"));
		zoo.addAnimal(new Lion("Simba"));
		zoo.addAnimal(new Elephant("Trunky"));
	}

	public Zoo getZoo() {
		return zoo;
	}
}

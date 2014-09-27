package nl.marcus.ember.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lion extends Animal {

	@JsonCreator
	public Lion(@JsonProperty("name") String name) {
		super("lion", name);
	}

	@Override
	public String getDiet() {
		return "carnivorous";
	}
	
	@JsonProperty
	public boolean hasManes() {
		return true;
	}

	@Override
	public String toString() {
		return "Lion [getName()=" + getName() + 
				", getType()=" + getDiet() + 
				", hasManes()=" + hasManes() + 
				"]";
	}
}
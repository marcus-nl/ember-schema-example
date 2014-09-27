package nl.marcus.ember.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Elephas")
public class Elephant extends Animal {

	@JsonCreator
	public Elephant(@JsonProperty("name") String name) {
		super("elephant", name);
	}

	@Override
	public String getDiet() {
		return "herbivorous";
	}

	@JsonProperty
	public int getTrunkLength() {
		return 10;
	}

	@Override
	public String toString() {
		return "Elephant [getName()=" + getName() + 
				", getType()=" + getDiet() + 
				", getTrunkLength()=" + getTrunkLength() + 
				"]";
	}
}
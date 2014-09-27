package nl.marcus.ember.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ 
	@Type(value = Lion.class, name = "lion"), 
	@Type(value = Elephant.class, name = "elephant") 
})
public abstract class Animal {
	
	private final String species;
	private final String name;

	protected Animal(String species, String name) {
		this.species = species;
		this.name = name;
	}
	
	@JsonProperty("species")
	public String getSpecies() {
		return species;
	}
	
	@JsonProperty("name")
	public final String getName() {
		return name;
	}

	@JsonProperty("diet")
	public abstract String getDiet();
	
	public String getFoo() {
		return "foo";
	}
}
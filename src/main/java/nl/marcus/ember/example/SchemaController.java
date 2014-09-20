package nl.marcus.ember.example;

import nl.marcus.ember.EmberSchema;
import nl.marcus.ember.EmberSchemaGenerator;
import nl.marcus.ember.example.model.Animal;
import nl.marcus.ember.example.model.Zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

@RestController
public class SchemaController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private final Supplier<EmberSchema> schemaSupplier = Suppliers.memoize(this::createSchema);

	private EmberSchema createSchema() {
		EmberSchemaGenerator collector = new EmberSchemaGenerator(objectMapper);

		collector.addClass(Zoo.class);
		collector.addHierarchy(Animal.class);

		return collector.getEmberSchema();
	}
	
	@RequestMapping("ember-schema")
	@ResponseBody
	public EmberSchema getSchema() {
		return schemaSupplier.get();
	}
}

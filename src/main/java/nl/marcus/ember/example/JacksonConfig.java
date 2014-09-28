package nl.marcus.ember.example;

import nl.marcus.ember.example.model.Animal;

import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ObjectMapper jacksonObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.registerModule(new ParameterNamesModule());
		
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		objectMapper.addMixInAnnotations(Animal.class, TypeDiscriminator.class);
//		objectMapper.addMixInAnnotations(Object.class, ExplicitPropertiesMixin.class);
		
//		objectMapper.setFilters(
//				new SimpleFilterProvider()
//					.addFilter("explicitProperties", new ExplicitPropertiesFilter())
//			);
		
		return objectMapper;
	}

	@SuppressWarnings("unused")
	private void registerSubtypes(ObjectMapper objectMapper, Class<?> base) {
		Reflections reflections = new Reflections(base.getPackage().getName());
		Class<?>[] subTypes = reflections.getSubTypesOf(base).toArray(new Class<?>[0]);
		objectMapper.registerSubtypes(subTypes);
	}
}

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "$type")
interface TypeDiscriminator {}

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
interface IdPropertyIdentity {}

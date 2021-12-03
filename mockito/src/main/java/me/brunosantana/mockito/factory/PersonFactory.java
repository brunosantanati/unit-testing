package me.brunosantana.mockito.factory;

import java.util.Optional;

import org.springframework.stereotype.Component;

import me.brunosantana.mockito.model.Person;

@Component
public class PersonFactory {
	
	public Person create(Optional<String> nameOptional) {
		if(nameOptional.isPresent()) {
			return new Person(nameOptional.get());
		}else {
			throw new RuntimeException("Empty name");
		}
	}

}

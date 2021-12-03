package me.brunosantana.mockito.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import me.brunosantana.mockito.model.Person;

@RunWith(SpringRunner.class)
public class PersonFactoryTest {
	
	@InjectMocks
	private PersonFactory personFactory;
	
	@Test
	public void should_CreateAPersonSuccessfully() {
		Optional<String> nameOptional = spy(Optional.of("Bruno")); //required mockito-inline dependency in order to mock/spy a final class like Optional
		
		Person person = personFactory.create(nameOptional);
		
		assertEquals("Bruno", person.getName());
		verify(nameOptional, times(1)).isPresent();
		verify(nameOptional, times(1)).get();
	}

}

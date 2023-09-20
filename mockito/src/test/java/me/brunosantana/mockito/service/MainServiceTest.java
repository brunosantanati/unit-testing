package me.brunosantana.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.any;

import java.util.HashMap;
import java.util.Optional;

import me.brunosantana.mockito.factory.PersonFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class) //No trabalho usei @ExtendWith(MockitoExtension.class)
public class MainServiceTest {
	
	@InjectMocks
	private MainService mainService;
	
	@Mock
	private OtherService otherService;

	@Mock
	private PersonFactory personFactory;

	@Captor
	ArgumentCaptor<Optional<String>> captor;
	
	@Before
	public void setup() {
		ReflectionTestUtils.setField(mainService, "key", "mykeyyyyyyyyyyyy");
	}

	@Test
	public void testGetText() {
		when(otherService.getText()).thenReturn("any text");
		
		String result = mainService.getText();
		
		assertEquals("any text", result);
		verify(otherService, times(1)).getText();
	}
	
	@Test
	public void testPassToken() {
				
		mainService.passToken("Bearer JWT");
		
		verify(otherService, times(1)).passToken(matches("^Bearer\\s.+"));
	}
	
	@Test
	public void testPrintKey() {
		String key = mainService.getKey();
		
		System.out.println("############## " + key);
		assertEquals("mykeyyyyyyyyyyyy", key);
	}
	
	@Test
	public void testFillMap() {
		HashMap<String, Object> map = spy(HashMap.class);
		mainService.fillMap(map);
		
		verify(map, times(1)).put(matches("someKey"), any(String.class));
	}

	@Test
	public void testUsingArgumentCaptor() {

		mainService.getPersonWithRandomName(1);

		verify(personFactory, times(1)).create(captor.capture());

		Optional<String> optional = captor.getValue();
		assertEquals("Rumpelstiltskin", optional.orElse("INVALIDO"));
	}
	
}

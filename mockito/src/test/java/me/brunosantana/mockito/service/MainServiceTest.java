package me.brunosantana.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {
	
	@InjectMocks
	private MainService mainService;
	
	@Mock
	private OtherService otherService;
	
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
	
}

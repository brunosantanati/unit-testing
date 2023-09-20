package me.brunosantana.mockito.service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import me.brunosantana.mockito.factory.PersonFactory;
import me.brunosantana.mockito.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	@Autowired
	private OtherService otherService;

	@Autowired
	private PersonFactory personFactory;
	
	@Value("${my.key}")
	private String key;
	
	public String getText() {
		return otherService.getText();
	}
	
	public void passToken(String token) {
		otherService.passToken(token);
	}

	public String getKey() {
		return key;
	}
	
	public void fillMap(Map<String, Object> map) {
		map.put("someKey", "someValue");
	}

	public Person getPersonWithRandomName(int randomNumber) {

		String randomName = "";

		switch (randomNumber) {
			case 0:
				randomName = "Bruno";
				break;
			case 1:
				randomName = "Rumpelstiltskin";
				break;
			case 2:
				randomName = "Frankenstein";
				break;
		}

		return personFactory.create(Optional.of(randomName));
	}
}

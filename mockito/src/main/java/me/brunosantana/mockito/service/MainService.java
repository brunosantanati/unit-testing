package me.brunosantana.mockito.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	@Autowired
	private OtherService otherService;
	
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
}

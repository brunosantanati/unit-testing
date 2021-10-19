package me.brunosantana.mockito.service;

import org.springframework.stereotype.Service;

@Service
public class OtherService {
	
	public String getText() {
		return "Mussum Ipsum, cacilds vidis litro abertis. Atirei o pau no gatis, per gatis num morreus.";
	}

	public void passToken(String token) {
		//do nothing
	}
}

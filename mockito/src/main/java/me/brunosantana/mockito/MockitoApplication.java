package me.brunosantana.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.brunosantana.mockito.service.MainService;

@SpringBootApplication
public class MockitoApplication implements ApplicationRunner{
	
	@Autowired
	private MainService mainService;

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String key = mainService.getKey();
		System.out.println("############## " + key);
	}

}

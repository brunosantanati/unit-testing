package me.brunosantana.model.steps;

import java.util.List;

public class AuthorizationChecker implements Step {

	private List<Step> steps;

	public void setPossibleNextSteps(List<Step> steps) {
		this.steps = steps;
		
	}

	public void setResponse(String response) {
		throw new RuntimeException("Does not make sense a response here");	
	}
	
	public void setTest() {
		System.out.println("apenas teste");
	}

}

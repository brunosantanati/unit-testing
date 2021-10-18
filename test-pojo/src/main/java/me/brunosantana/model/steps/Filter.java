package me.brunosantana.model.steps;

import java.util.List;

public class Filter implements Step {
	
	private List<Step> steps;
	private String response;

	public void setPossibleNextSteps(List<Step> steps) {
		this.steps = steps;
		
	}

	public void setResponse(String response) {
		this.response = response;
	}

}

package me.brunosantana.model.steps;

import java.util.List;

public interface Step {
	
	void setPossibleNextSteps(List<Step> steps);
	void setResponse(String response);

}

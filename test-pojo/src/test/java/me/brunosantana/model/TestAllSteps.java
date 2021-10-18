package me.brunosantana.model;

import java.util.ArrayList;

import org.junit.Test;

import me.brunosantana.model.steps.AuthorizationChecker;
import me.brunosantana.model.steps.Filter;
import me.brunosantana.model.steps.Step;
import me.brunosantana.utils.PojoTestUtils;

public class TestAllSteps {
	
	@Test
    public void testAccesors_shouldAccessProperField() {
		PojoTestUtils.validateAccessors(AuthorizationChecker.class);
		PojoTestUtils.validateAccessors(Filter.class);
		//Não conseguiu testar quando o atributo tem o nome diferente do setter
		//Não conseguiu testar quando tem o setter mas não tem atributo
    }
	
	@Test(expected=RuntimeException.class)
	public void testManually() {
		new Filter().setPossibleNextSteps(new ArrayList<Step>()); //testar quando o atributo tem o nome diferente do setter
		new AuthorizationChecker().setPossibleNextSteps(new ArrayList<Step>()); //testar quando o atributo tem o nome diferente do setter
		new AuthorizationChecker().setTest(); //testar quando tem o setter mas não tem atributo
		new AuthorizationChecker().setResponse(""); //testar quando tem o setter mas não tem atributo
	}

}
